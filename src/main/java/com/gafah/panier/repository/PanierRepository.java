package com.gafah.panier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gafah.panier.model.Panier;

public interface PanierRepository extends JpaRepository<Panier, Long>{

}
