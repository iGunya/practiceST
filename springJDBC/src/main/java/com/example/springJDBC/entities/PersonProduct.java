package com.example.springJDBC.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_product")
public class PersonProduct  {
    @EmbeddedId
    private OrderKey orderKey;

    @ManyToOne
    @JoinColumn(name = "person_id", insertable = false,updatable = false)
    private Person person_id;

    @ManyToOne
    @JoinColumn(name = "product_id",insertable = false,updatable = false)
    private Product product_id;

    public PersonProduct(){}

    public Person getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Person person_id) {
        this.person_id = person_id;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public PersonProduct(Long person_id, Long product_id) {
        this.orderKey=new OrderKey(person_id,product_id);

    }
}
