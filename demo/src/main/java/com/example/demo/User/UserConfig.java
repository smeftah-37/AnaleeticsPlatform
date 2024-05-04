package com.example.demo.User;

import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
        //     // User safae = new User("safae","safae@gmail.com",LocalDate.of(2002,04,18),"Math","image.png");
        //     // User islam = new User("islam","islam@gmail.com",LocalDate.of(2002,04,18),"data scienst","image.png");
        //  repository.saveAll(List.of(safae,islam));   
        };



    }
    
}
