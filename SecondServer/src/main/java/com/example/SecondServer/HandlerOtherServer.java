package com.example.SecondServer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HandlerOtherServer", value = "/other-server")
public class HandlerOtherServer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        StringBuilder resp= new StringBuilder(request.getParameter("messege"));
        writer.write(resp.reverse().toString());

    }
}
