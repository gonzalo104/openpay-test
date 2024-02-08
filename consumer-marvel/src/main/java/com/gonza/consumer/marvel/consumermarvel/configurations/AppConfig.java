package com.gonza.consumer.marvel.consumermarvel.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.gonza.consumer.marvel.consumermarvel.interceptors.MarvelRestTemplateCustomizer;

@Configuration
public class AppConfig {
  @Value("${marvel.publickey}")
  private String publicKey;

  @Value("${marvel.privatekey}")
  private String privateKey;

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
  return builder.build();
  }

  @Bean
  public MarvelRestTemplateCustomizer marvelRestTemplateCustomizer() {
    return new MarvelRestTemplateCustomizer(publicKey, privateKey);
  }
}
