package com.gafah.panier.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gafah.panier.model.User;
import com.gafah.panier.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	  @Autowired
	    UserService service;
	 
	  @GetMapping("/{username}/{password}")
	    public ResponseEntity<User> getUser(@PathVariable("username") String username,
	            @PathVariable("password") String password) {
		  
	        User user = service.getUser(username,password);
	        System.out.println(">>>>>>>>>>>>> "+user);
	        return new ResponseEntity<User>(user, new HttpHeaders(), HttpStatus.OK);
	    }
	 
}