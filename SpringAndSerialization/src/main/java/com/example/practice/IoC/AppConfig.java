package com.example.practice.IoC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
/**
 *  ComponentScan чтобы опробовать сделать бином класс Photograph через
 *  анотацию @Component  и внедрить зависимость через @Autowired
 */
@ComponentScan("com.example.practice")
public class AppConfig {
    @Bean(name="cameraRoll")
    public CameraRoll cameraRoll(){
        return new ColorCameraRoll();
    }


    @Bean(name="camera")
    public Camera camera(CameraRoll cameraRoll){
        Camera camera = new Camera();
        camera.setCameraRoll(cameraRoll);
        return camera;
    }
}
