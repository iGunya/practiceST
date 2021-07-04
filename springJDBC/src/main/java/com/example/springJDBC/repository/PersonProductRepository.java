package com.example.springJDBC.repository;

import com.example.springJDBC.entities.PersonProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonProductRepository extends JpaRepository<PersonProduct, Long> {
}
