package com.gonza.api.maverl.apirest.apirestmarvel.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gonza.consumer.marvel.consumermarvel.configurations.AppConfig;

@Configuration
@Import(AppConfig.class)
@ComponentScan(basePackages = { "com.gonza.consumer.marvel.consumermarvel.services" })
public class AppConfiguration implements WebMvcConfigurer {

  @Autowired
  private HandlerInterceptor logInterceptor;

  @SuppressWarnings("null")
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry
      .addInterceptor(logInterceptor);
      //.addPathPatterns("app/characters/**");
  }

}