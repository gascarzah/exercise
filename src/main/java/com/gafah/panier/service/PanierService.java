package com.gafah.panier.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gafah.panier.exception.RecordNotFoundException;
import com.gafah.panier.model.Panier;
import com.gafah.panier.model.Product;
import com.gafah.panier.repository.PanierRepository;
import com.gafah.panier.repository.ProductRepository;

@Service
public class PanierService {

    @Autowired
    PanierRepository panierRepository;
    
    @Autowired
    ProductRepository productRepository;
     
    public List<Panier> getAllPaniers()
    {
        List<Panier> panierList = panierRepository.findAll();
         
        if(panierList.size() > 0) {
            return panierList;
        } else {
            return new ArrayList<Panier>();
        }
    }
     
    public Panier getPanierById(Long id) throws RecordNotFoundException
    {
        Optional<Panier> panier = panierRepository.findById(id);
         
        if(panier.isPresent()) {
            return panier.get();
        } else {
            throw new RecordNotFoundException("No Panier record exist for given id");
        }
    }
     
    public Panier createOrUpdatePanier(Long id) throws RecordNotFoundException
    {
        
        System.out.println(id);
        Optional<Product> product = productRepository.findById(id);
		
        Panier panier = new Panier();
        if(product.isPresent())
        {
            
            panier.setIdProd(product.get().getId());
    		panier.setName(product.get().getName());
    		panier.setPrice(product.get().getPrice());
            panier = panierRepository.save(panier);
             
            
        } 
        return panier;
    }
     
    public void deletePanierById(Long id) throws RecordNotFoundException
    {
        Optional<Panier> panier = panierRepository.findById(id);
         
        if(panier.isPresent())
        {
            panierRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No panier record exist for given id");
        }
    }
	
}
