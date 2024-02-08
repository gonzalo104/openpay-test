package com.gonza.api.maverl.apirest.apirestmarvel.configurations;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.gonza.consumer.marvel.consumermarvel.configurations.AppConfig;

@Configuration
@Import(AppConfig.class)
@ComponentScan(basePackages = { "com.gonza.consumer.marvel.consumermarvel.services" })
public class AppConfiguration {

}