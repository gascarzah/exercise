package com.gafah.panier.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gafah.panier.exception.RecordNotFoundException;
import com.gafah.panier.model.Product;
import com.gafah.panier.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;
     
    public List<Product> getAllProducts()
    {
        List<Product> productList = repository.findAll();
         
        if(productList.size() > 0) {
            return productList;
        } else {
            return new ArrayList<Product>();
        }
    }
     
    public Product getProductById(Long id) throws RecordNotFoundException
    {
        Optional<Product> product = repository.findById(id);
         
        if(product.isPresent()) {
            return product.get();
        } else {
            throw new RecordNotFoundException("No product record exist for given id");
        }
    }
     
    public Product createOrUpdateProduct(Product entity) throws RecordNotFoundException
    {
        Optional<Product> product = repository.findById(entity.getId());
         
        if(product.isPresent())
        {
            Product newEntity = product.get();
            newEntity.setName(entity.getName());
            newEntity.setPrice(entity.getPrice());
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    }
     
    public void deleteProductById(Long id) throws RecordNotFoundException
    {
        Optional<Product> product = repository.findById(id);
         
        if(product.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No panier record exist for given id");
        }
    }
	
}
