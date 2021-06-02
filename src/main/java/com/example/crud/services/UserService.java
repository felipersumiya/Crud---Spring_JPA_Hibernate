package com.example.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entities.User;
import com.example.crud.repositories.UserRepository;


@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> findAll(){
			
		return userRepository.findAll();
		
		
	}
	
	public User findById(Long id) {
		
		Optional<User> obj = userRepository.findById(id);
	
		return obj.get();
	}

}