package com.example.SpringMVC;

import com.example.SpringMVC.postExample.PostExampleController;
import com.example.SpringMVC.postExample.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean(name = "repository")
    public ProductRepository productRepository(){
        return new ProductRepository();
    }

}
