package com.example.springJDBC.service;

import com.example.springJDBC.entities.Person;
import com.example.springJDBC.entities.PersonProduct;
import com.example.springJDBC.entities.Product;
import com.example.springJDBC.repository.PersonProductRepository;
import com.example.springJDBC.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final int COUNT_ON_PAGE=5;
    private int countPage;
    ProductRepository repository;
    PersonProductRepository personProductRepository;

    public List<Product> getAllProducts (){
        return repository.findAll();
    }

    public List<Product> getAllProductsPerson (Long id){
        List<PersonProduct> t=repository.findAllProductPerson(id);
        return t.stream().map(e->e.getProduct_id()).collect(Collectors.toList());
    }

    public void add(Product product, Person person) {
        repository.save(product);
        Long idProduct=findByName(product.getName());
        PersonProduct t = new PersonProduct(person.getId(),idProduct);
        personProductRepository.save(t);
    }

    public Long findByName(String name){
        return repository.findByName(name).getId();
    }

    public List<Product> getNowPage(int numberPage,Long id){
        List<Product> t= getAllProductsPerson(id);
        countPage = t.size()/COUNT_ON_PAGE;
        int fistIndex = (numberPage-1)*COUNT_ON_PAGE;
        return t.stream()
                .skip(fistIndex)
                .limit(COUNT_ON_PAGE)
                .collect(Collectors.toList());
    }


    public int getCOUNT_ON_PAGE() {
        return COUNT_ON_PAGE;
    }

    public int getCountPage() {
        return countPage;
    }

    @Autowired
    public ProductService(ProductRepository repository,PersonProductRepository personProductRepository) {
        this.personProductRepository=personProductRepository;
        this.repository = repository;
    }
}
