package com.example.thymeleafSpring;

import com.example.thymeleafSpring.pagination.ProductRepository;
import com.example.thymeleafSpring.pagination.ProductServise;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean("repository")
    public ProductRepository beanRepository() {
        return new ProductRepository();
    }

    @Bean("servise")
    public ProductServise beanServise(ProductRepository repository) {
        return new ProductServise(repository);
    }
}
