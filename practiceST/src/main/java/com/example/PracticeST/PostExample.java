package com.example.PracticeST;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Post запрос (3 задание)
@WebServlet(name = "PostExample", value = "/PostExample")
public class PostExample extends HttpServlet {
    private List<Product> products;
    //инициализируем корзину продуктами (запросами она будет дополнятся)
    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        products=new ArrayList<>();
        products.add(new Product("Bread",30));
        products.add(new Product("Milk",35));
        products.add(new Product("Apple",80));
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().write("<p> In the shopping cart: </p>");
        //получаем параметры
        String nameProduct = request.getParameter("name");
        String priceProduct = request.getParameter("price");
        products.add(new Product(nameProduct, Integer.parseInt(priceProduct)));
        log(nameProduct+" "+priceProduct);
        //выводим содержиоме корзины
        for (Product product : products) {
            response.getWriter().write("<p> " + product.getName() + " coast: " + product.getPrice() + "</p>");
        }
        //ссылка обратно добавить товар
        response.getWriter().write("<a href=\"/PracticeST-1.0-SNAPSHOT/post-example\">Back</a>");

    }
}

class Product {
    private String name;
    private int price;

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
