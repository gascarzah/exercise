package com.gafah.panier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gafah.panier.model.User;
import com.gafah.panier.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
     
    
    public User getUser(String username, String password){
		return userRepository.getUser(username, password);
	}
    
     
   
	
}
