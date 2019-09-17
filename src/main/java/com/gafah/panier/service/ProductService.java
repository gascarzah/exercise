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
        List<Product> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Product>();
        }
    }
     
    public Product getProductById(Long id) throws RecordNotFoundException
    {
        Optional<Product> employee = repository.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No product record exist for given id");
        }
    }
     
    public Product createOrUpdateProduct(Product entity) throws RecordNotFoundException
    {
        Optional<Product> employee = repository.findById(entity.getId());
         
        if(employee.isPresent())
        {
            Product newEntity = employee.get();
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
        Optional<Product> employee = repository.findById(id);
         
        if(employee.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
	
}
