package com.example.Report.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configclass {

    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
}
