package com.example.practice.serializators;

import com.example.practice.IoC.Photogaph;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component("toJson")
public class ToJson implements Serializator {
    @Override
    public void modificationAndWrite(Object o) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File("D:\\Pkactic\\photograph.json"), o);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonInString = null;
        try {
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonInString);
    }
}
