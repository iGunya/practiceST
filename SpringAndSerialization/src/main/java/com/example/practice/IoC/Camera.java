package com.example.practice.IoC;

import org.springframework.beans.factory.annotation.Value;

public class Camera {


    @Value("Sony 7500")
    private String model;
    private CameraRoll cameraRoll;

    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void doPhotogaph(){
        System.out.println("Спуск затвора камеры");
        cameraRoll.processing();
    }
}
