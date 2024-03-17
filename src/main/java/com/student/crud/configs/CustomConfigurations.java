package com.student.crud.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfigurations {

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
