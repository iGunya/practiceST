package com.example.practice.IoC;

import org.springframework.beans.factory.annotation.Value;

public class ColorCameraRoll implements CameraRoll {
    @Value("цветная")
    private String type;

    @Override
    public void processing() {
        System.out.println("+ 1 "+type+" фотография ");
    }

    public String getType() {
        return type;
    }
}
