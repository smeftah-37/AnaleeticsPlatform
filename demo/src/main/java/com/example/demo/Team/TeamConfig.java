package com.example.demo.Team;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeamConfig {
    
    @Bean
    CommandLineRunner commandLineRunner1(TeamRepository repository)
    {
        return args -> {

        };
    }
}
