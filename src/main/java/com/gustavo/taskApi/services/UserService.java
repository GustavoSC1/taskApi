package com.gustavo.taskApi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.taskApi.dtos.UserDto;
import com.gustavo.taskApi.dtos.UserNewDto;
import com.gustavo.taskApi.entities.User;
import com.gustavo.taskApi.repositories.UserRepository;

import com.gustavo.taskApi.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserDto find(Long id) {		
		return new UserDto(findById(id));
	}
	
	public UserDto insert(UserNewDto dto) {
		User user = new User(null, dto.getName(), dto.getBirthDate(), dto.getCpf(), dto.getEmail(), dto.getPassword());
		user = userRepository.save(user);
		return new UserDto(user);
	}
	
	public UserDto update(Long id, UserNewDto dto) {
		User user = findById(id);
		user.setName(dto.getName());
		user.setBirthDate(dto.getBirthDate());
		user.setCpf(dto.getCpf());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		
		user = userRepository.save(user);	
		
		return new UserDto(user);
	}
	
	public User findById(Long id) {
		Optional<User> userOptional = userRepository.findById(id);
		User user = userOptional.orElseThrow(() -> new ObjectNotFoundException( "Objeto não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
	
		return user;
	}

}
