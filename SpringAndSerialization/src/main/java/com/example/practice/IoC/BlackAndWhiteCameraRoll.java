package com.example.practice.IoC;

import org.springframework.beans.factory.annotation.Value;

public class BlackAndWhiteCameraRoll implements CameraRoll {
    @Value("Черно-белая")
    String type;

    @Override
    public void processing() {
        System.out.println("+ 1 "+type+" фотография");
    }

    public String getType() {
        return type;
    }
}
