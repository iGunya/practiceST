package com.example.springJDBC.repository;

import com.example.springJDBC.entities.PersonProduct;
import com.example.springJDBC.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("Select p from PersonProduct p where p.orderKey.person_id = :id")
    List<PersonProduct> findAllProductPerson(@Param("id")Long id);

    Product findByName(String name);
}
