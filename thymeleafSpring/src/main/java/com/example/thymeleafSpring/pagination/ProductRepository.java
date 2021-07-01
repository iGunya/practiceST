package com.example.thymeleafSpring.pagination;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//заглушка БД
public class ProductRepository {
    private List<Product> products;
    @PostConstruct
    public void init(){
        products=new ArrayList<>();
        products.add(new Product("Bread",30));
        products.add(new Product("Milk",35));
        products.add(new Product("Apple",80));
    }

    public void add(Product product){
        products.add(product);
    }


    public List<Product> getProducts() {
        return products;
    }
}

class Product {
    private String name;
    private int price;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product() {
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}