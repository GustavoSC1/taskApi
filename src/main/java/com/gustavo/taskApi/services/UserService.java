package com.gustavo.taskApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.taskApi.dtos.UserDto;
import com.gustavo.taskApi.dtos.UserNewDto;
import com.gustavo.taskApi.entities.User;
import com.gustavo.taskApi.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserDto insert(UserNewDto dto) {
		User user = new User(null, dto.getName(), dto.getBirthDate(), dto.getCpf(), dto.getEmail(), dto.getPassword());
		user = userRepository.save(user);
		return new UserDto(user);
	}

}
