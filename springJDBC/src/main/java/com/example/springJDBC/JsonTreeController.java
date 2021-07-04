package com.example.springJDBC;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

/**
 * Выводит Json файл любой вложенности в виде раскрывающегося дерева
 */

@Controller
public class JsonTreeController {
    @GetMapping("/tree")
    public String outputTree(Model model){

//        String str ="{\"namePhotograph\":\"Vasya\",\"camera\":{\"model\":\"Sony 7500\",\"cameraRoll\":{\"type\":\"цветная\"}},\"photos\":{\"1\":\"Лес\",\"2\":\"Поле\",\"3\":\"Река\",\"4\":\"Зверь\",\"5\":\"Лес\",\"6\":\"Город\"}}";
        String str = "{\"user_id\":10,\"session_id\":\"2c2l3h4ii271aojentejtdcmh3\",\"products\":[{\"product_id\":15,\"options\":{\"15\":[45,47],\"18\":52},\"quantity\":1,\"price\":1500},{\"product_id\":16,\"options\":{\"15\":[47,48],\"18\":51},\"quantity\":2,\"price\":1000}]}\n";
//        String str = "{\n" +
//                "  \"orderID\": 12345,\n" +
//                "  \"shopperName\": \"John Smith\",\n" +
//                "  \"shopperEmail\": \"johnsmith@example.com\",\n" +
//                "  \"contents\": [\n" +
//                "    {\n" +
//                "      \"productID\": 34,\n" +
//                "      \"productName\": \"SuperWidget\",\n" +
//                "      \"quantity\": 1\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"productID\": 56,\n" +
//                "      \"productName\": \"WonderWidget\",\n" +
//                "      \"quantity\": 3\n" +
//                "    }\n" +
//                "  ],\n" +
//                "  \"orderCompleted\": true\n" +
//                "}";
        HashMap<String,Object> result=null;
        try {
            result =
                    new ObjectMapper().readValue(str, HashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        model.addAttribute("info",result);

        return "tree";
    }
}