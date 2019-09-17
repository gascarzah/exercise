package com.gafah.panier.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gafah.panier.exception.RecordNotFoundException;
import com.gafah.panier.model.Product;
import com.gafah.panier.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductyController {

	  @Autowired
	    ProductService service;
	 
	    @GetMapping
	    public ResponseEntity<List<Product>> getAllProducts() {
	        List<Product> list = service.getAllProducts();
	 
	        return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	    @GetMapping("/{id}")
	    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id)
	                                                    throws RecordNotFoundException {
	        Product entity = service.getProductById(id);
	 
	        return new ResponseEntity<Product>(entity, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	    @PostMapping
	    public ResponseEntity<Product> createOrUpdateProduct(@RequestBody Product employee)
	                                                    throws RecordNotFoundException {
	        Product updated = service.createOrUpdateProduct(employee);
	        return new ResponseEntity<Product>(updated, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	    @DeleteMapping("/{id}")
	    public HttpStatus deleteProductById(@PathVariable("id") Long id)
	                                                    throws RecordNotFoundException {
	        service.deleteProductById(id);
	        return HttpStatus.FORBIDDEN;
	    }
	
	
}
