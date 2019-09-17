package com.gafah.panier.repository;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gafah.panier.model.Product;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductTest {

	@Autowired
	ProductRepository repository;

	
	
	@Test
	public void testGetProduct() {
		Optional<Product> p = repository.findById(2l);
		Assert.assertTrue(p.get().getName().equals("Grapes"));
	}

	@Test
	public void testAddProduct() {
		Product p =new Product();
		p.setId(99l);
		p.setName("cigarettes");
		p.setPrice(2.22);
		
		Assert.assertNotNull(repository.save(p));
	}
	
	@Test
	public void testAllProducts() {
		List<Product> list = repository.findAll();
		System.out.println(">>>>>>>>>> "+list.size());
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void deleteProduct() {
		           repository.deleteById(1l);
        
	}
	
}
