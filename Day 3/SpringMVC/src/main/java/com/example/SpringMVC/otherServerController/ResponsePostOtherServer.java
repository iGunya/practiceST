package com.example.SpringMVC.otherServerController;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ResponsePostOtherServer  {

    private final String URL="http://localhost:8080/SecondServer-1.0-SNAPSHOT/other-server";

    @GetMapping("/proxy")
    public String startPage(){
        return "inputForm";
    }

    @PostMapping("/proxy")
    protected String doPost(@RequestParam(value="messege") String messege, Model model) {

        model.addAttribute("inputString",messege);
        //создаем клиент
        try(CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(URL);

            //формируем тело запроса
            List<NameValuePair> parametrs = new ArrayList<>();
            parametrs.add(new BasicNameValuePair("messege", messege));
            httpPost.setEntity(new UrlEncodedFormEntity(parametrs));
            //отправляем запрос - получаем ответ
            try (CloseableHttpResponse response2 = httpclient.execute(httpPost)) {
                HttpEntity entity2 = response2.getEntity();
                model.addAttribute("outputString",EntityUtils.toString(entity2));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "outputOterServer";
    }
}