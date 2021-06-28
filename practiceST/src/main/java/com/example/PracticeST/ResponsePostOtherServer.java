package com.example.PracticeST;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 *   пятое задание
 *   запрос к другму серверу
 *   отрпавляем введенную строку на сервер
 *   сервер возвращает развернутую
*/
@WebServlet(name = "ResponsePost", value = "/ResponsePost")
public class ResponsePostOtherServer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Страница ответа
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<p> Пришла строка : "+request.getParameter("messege")+" </p>");
        log(request.getParameter("messege"));
        //создаем клиент
        try(CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("http://localhost:8080/SecondServer-1.0-SNAPSHOT/other-server");

            List<NameValuePair> parametrs = new ArrayList<>();
            parametrs.add(new BasicNameValuePair("messege", request.getParameter("messege")));
            //формируем тело запроса
            httpPost.setEntity(new UrlEncodedFormEntity(parametrs));
            //отправляем запрос - получаем ответ
            try (CloseableHttpResponse response2 = httpclient.execute(httpPost)) {
                HttpEntity entity2 = response2.getEntity();
                response.getWriter().write("<p> Вернулась строка : " + EntityUtils.toString(entity2) + " </p>");
                log(EntityUtils.toString(entity2));
            }
        }

    }
}
