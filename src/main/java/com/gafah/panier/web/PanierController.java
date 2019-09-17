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
import com.gafah.panier.model.Panier;
import com.gafah.panier.model.Product;
import com.gafah.panier.service.PanierService;

@RestController
@RequestMapping("/paniers")
public class PanierController {

	  @Autowired
	    PanierService service;
	 
	    @GetMapping
	    public ResponseEntity<List<Panier>> getAllPaniers() {
	        List<Panier> list = service.getAllPaniers();
	        System.out.println(list.size());
	        return new ResponseEntity<List<Panier>>(list, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	    @GetMapping("/{id}")
	    public ResponseEntity<Panier> getPanierById(@PathVariable("id") Long id)
	                                                    throws RecordNotFoundException {
	        Panier entity = service.getPanierById(id);
	        System.out.println(entity);
	        return new ResponseEntity<Panier>(entity, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	    @PostMapping("/save/{id}")
	    public ResponseEntity<Panier> createOrUpdatePanier(@PathVariable("id") Long id)
	                                                    throws RecordNotFoundException {
	        Panier updated = service.createOrUpdatePanier(id);
	        return new ResponseEntity<Panier>(updated, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	    @DeleteMapping("/delete/{id}")
	    public HttpStatus deletePanierById(@PathVariable("id") Long id)
	                                                    throws RecordNotFoundException {
	        service.deletePanierById(id);
	        return HttpStatus.OK;
	    }
	
	
}
