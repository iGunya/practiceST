package com.example.practice.serializators;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component("toXml")
public class ToXML implements Serializator {
    @Override
    public void modificationAndWrite(Object o) {
        ObjectMapper mapper = new XmlMapper();

        try {
            mapper.writeValue(new File("D:\\Pkactic\\photograph.xml"), o);
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
