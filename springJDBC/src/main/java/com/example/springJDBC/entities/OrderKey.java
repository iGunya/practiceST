package com.example.springJDBC.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

@Embeddable
public class OrderKey implements Serializable {
    @Column(name = "person_id")
    private Long person_id;

    @Column(name = "product_id")
    private Long product_id;

    public OrderKey(Long person_id, Long product_id) {
        this.person_id = person_id;
        this.product_id = product_id;
    }

    public OrderKey(){}

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
}
