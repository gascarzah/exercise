package com.gafah.panier.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gafah.panier.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
//@Configuration
//@EnableJpaRepositories(basePackages = {
//    "com.gafah.panier.repository.custom"
//})
public class UserTest {

	@Autowired
	UserRepository userRepository;

	
	
	@Test
	public void testGetUser() {
		User p = userRepository.getUser("pepe", "pepe");
		Assert.assertTrue(p.getName().equals("pepito"));
	}


	
}
