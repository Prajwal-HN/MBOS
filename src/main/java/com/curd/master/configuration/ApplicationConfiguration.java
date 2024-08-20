package com.curd.master.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public RestTemplate getRestTemplateBean() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper getObjectMapperBean() {
        return new ObjectMapper();
    }
}
