package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.example.demo.models.User;

@Service
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByLoginAndPass(String login, String pass);

}
