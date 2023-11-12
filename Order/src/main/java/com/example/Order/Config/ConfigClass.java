package com.example.Order.Config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.naming.spi.ObjectFactory;
import java.beans.Encoder;

@Configuration
public class ConfigClass {

    @Bean
    public ModelMapper modelMapper()
    {return new ModelMapper();}

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}