package com.example.practice.IoC;

import com.example.practice.serializators.Serializator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("photogaph")
public class Photogaph {
    @Value("Vasya")
    private String namePhotograph;
    private Camera camera;
    //просто чтоб посмотреть как отображается
    private Map<Integer,String> photos=new HashMap<>();

    @Autowired
    @Qualifier("toYami")
    Serializator serializator;

    @Autowired
    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void work(){
        for (int i = 0; i < 10; i++) {
            camera.doPhotogaph();
        }
        photos.put(1,"Лес");
        photos.put(2,"Поле");
        photos.put(3,"Река");
        photos.put(4,"Зверь");
        photos.put(5,"Лес");
        photos.put(6,"Город");
    }

    public String getNamePhotograph() {
        return namePhotograph;
    }

    public Camera getCamera() {
        return camera;
    }
    public void toSerialize(){
        serializator.modificationAndWrite(this);
    }

    public Map<Integer, String> getPhotos() {
        return photos;
    }
}
