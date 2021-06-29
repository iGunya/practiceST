package com.example.practice;

import com.example.practice.IoC.AppConfig;
import com.example.practice.IoC.Photogaph;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Photogaph photogaph = context.getBean("photogaph",Photogaph.class);
        photogaph.work();
        photogaph.toSerialize();
    }
}
