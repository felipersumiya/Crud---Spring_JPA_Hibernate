package com.example.crud.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.crud.entities.User;
import com.example.crud.repositories.UserRepository;
import com.example.crud.services.exceptions.DatabaseException;
import com.example.crud.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {

		return userRepository.findAll();

	}

	public User findById(Long id) {

		Optional<User> obj = userRepository.findById(id);

		return obj.orElseThrow(() -> new ResourceNotFoundException(id));

	}

	public User insert(User obj) {

		return userRepository.save(obj);

	}

	public void delete(Long id) {

		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {

			throw new ResourceNotFoundException(id);

		} catch (DataIntegrityViolationException e) {

			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(Long id, User obj) {

		try {
			User entity = userRepository.getOne(id);
			updateData(entity, obj);
			return userRepository.save(entity);
		}catch (EntityNotFoundException e){
			
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(User entity, User obj) {

		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());

	}

}
