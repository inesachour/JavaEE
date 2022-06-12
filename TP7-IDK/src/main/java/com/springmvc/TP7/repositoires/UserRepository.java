package com.springmvc.TP7.repositoires;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springmvc.TP7.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByLogin(final String login);
	
}

