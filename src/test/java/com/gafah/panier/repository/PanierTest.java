package com.gafah.panier.repository;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gafah.panier.model.Panier;
import com.gafah.panier.model.Product;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PanierTest {

	@Autowired
	PanierRepository panierRepository;

	@Autowired
	ProductRepository productRepository;
	
	
	@Test
	public void testGetPanier() {
		Optional<Panier> p = panierRepository.findById(1l);
		Assert.assertTrue(p.get().getName().equals("Grapes"));
	}

	@Test
	public void testAddPanier() {
		Optional<Product> product = productRepository.findById(1l);
		Panier p =new Panier();
		p.setIdProd(product.get().getId());
		p.setName(product.get().getName());
		p.setPrice(product.get().getPrice());
		
		Assert.assertNotNull(panierRepository.save(p));
	}
	
	@Test
	public void testAllPaniers() {
		List<Panier> list = panierRepository.findAll();
		System.out.println(">>>>>>>>>> "+list.size());
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void deletePanier() {
		           panierRepository.deleteById(1l);
        
	}
	
}
