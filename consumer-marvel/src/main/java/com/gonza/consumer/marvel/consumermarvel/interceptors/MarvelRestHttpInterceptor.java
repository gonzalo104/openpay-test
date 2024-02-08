package com.gonza.consumer.marvel.consumermarvel.interceptors;

import java.io.IOException;
import java.net.URI;
import java.security.MessageDigest;
import java.time.Instant;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

public class MarvelRestHttpInterceptor implements ClientHttpRequestInterceptor {
  private String publicKey;
  private String privateKey;

  public MarvelRestHttpInterceptor(String publicKey, String privateKey) {
    this.publicKey = publicKey;
    this.privateKey = privateKey;
  }

  @Override
  public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
      throws IOException {
    Long ts = Instant.now().getEpochSecond();
    String hash = generateHash(ts);
    String url = addQueryParams(request.getURI(), ts, hash, publicKey);

    HttpRequest newRequest = new HttpRequestWrapper(request) {
      @Override
      public URI getURI() {
        return URI.create(url);
      }
    };

    return execution.execute(newRequest, body);
  }

  private String addQueryParams(URI uri, long ts, String hash, String apiKey) {
    String queryString = "ts=" + ts + "&hash=" + hash + "&apikey=" + apiKey;
    if (uri.getQuery() == null) {
      return uri.toString() + "?" + queryString;
    } else {
      return uri.toString() + "&" + queryString;
    }
  }

  private String generateHash(Long ts) {
    String hash = ts + privateKey + publicKey;

    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] messageDigest = md.digest(hash.getBytes());
      StringBuilder hexString = new StringBuilder();

      for (byte b : messageDigest) {
        hexString.append(String.format("%02x", b));
      }

      return hexString.toString();
    } catch (Exception e) {
      throw new RuntimeException("Error generating hash");
    }
  }

}
