package com.example.thymeleafSpring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Controller
public class TreeController {
    @GetMapping("/tree")
    public String outputTree(Model model){

        String str ="{\"camera\":{\"model\":\"Sony 7500\",\"cameraRoll\":{\"type\":\"цветная\"}},\"photos\":{\"1\":\"Лес\",\"2\":\"Поле\",\"3\":\"Река\",\"4\":\"Зверь\",\"5\":\"Лес\",\"6\":\"Город\"}}";
        HashMap<String,Object> result=null;
        try {
            result =
                    new ObjectMapper().readValue(str, HashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        model.addAttribute("info",result);

        return "test2";
    }


}
