package com.example.thymeleafSpring.pagination;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServise {
    private final int COUNT_ON_PAGE=5;
    private int countPage;

    private ProductRepository productRepository;

    public List<Product> getNowPage(int numberPage){
        countPage = productRepository.getProducts().size()/COUNT_ON_PAGE;
        int fistIndex = (numberPage-1)*COUNT_ON_PAGE;
        return productRepository.getProducts().stream()
                .skip(fistIndex)
                .limit(COUNT_ON_PAGE)
                .collect(Collectors.toList());
    }

    public List<Product> getProducts(){
        return productRepository.getProducts();
    }

    public void add(Product product){
        productRepository.add(product);
    }

    public int getCOUNT_ON_PAGE() {
        return COUNT_ON_PAGE;
    }

    public int getCountPage() {
        return countPage;
    }

    public ProductServise(ProductRepository repository) {
        this.productRepository=repository;
    }
}
