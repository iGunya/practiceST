package com.example.practice.serializators;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component("toYami")
public class ToYami implements Serializator {
    @Override
    public void modificationAndWrite(Object o) {
        ObjectMapper mapper = new YAMLMapper();

        try {
            mapper.writeValue(new File("D:\\Pkactic\\photograph.yami"), o);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String XmlInString = null;
        try {
            XmlInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(XmlInString);
    }
}
