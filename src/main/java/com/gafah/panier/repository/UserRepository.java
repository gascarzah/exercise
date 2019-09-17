package com.gafah.panier.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gafah.panier.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

	@Query("select u from User u where u.username = :username and u.password = :password")
	public User getUser(String username, String password);
}
