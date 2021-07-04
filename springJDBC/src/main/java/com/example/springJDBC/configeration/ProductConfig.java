package com.example.springJDBC.configeration;

import com.example.springJDBC.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(basePackages={
        "com.example.springJDBC.repository"
})
public class ProductConfig {

}
