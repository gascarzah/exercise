package com.gafah.panier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gafah.panier.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
