package com.gonza.consumer.marvel.consumermarvel.interceptors;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.web.client.RestTemplate;

public class MarvelRestTemplateCustomizer implements RestTemplateCustomizer {

  private String publicKey;
  private String privateKey;

  public MarvelRestTemplateCustomizer(String publicKey, String privateKey) {
    this.publicKey = publicKey;
    this.privateKey = privateKey; 
  }

  @Override
  public void customize(RestTemplate restTemplate) {
    restTemplate.getInterceptors().add(new MarvelRestHttpInterceptor(publicKey, privateKey));
  }
}
