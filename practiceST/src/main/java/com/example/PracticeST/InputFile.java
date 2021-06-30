package com.example.PracticeST;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

//Загрузка файла
@WebServlet(name = "InputFile", value = "/InputFile")
@MultipartConfig(location = "D:\\Pkactic\\practiceST")
public class InputFile extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Part file = request.getPart("fileName");

        BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String line = br.readLine();
        response.getWriter().write("<p> Первые две строки файла </p>");
        response.getWriter().write("<p> " +line+ " </p>");
        log(line);

        line= br.readLine();
        response.getWriter().write("<p> " +line+ " </p>");
        log(line);

        file.write(file.getSubmittedFileName());

    }
}