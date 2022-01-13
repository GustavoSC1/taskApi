package com.gustavo.taskApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.taskApi.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	boolean existsByCpfOrEmail(String cpf, String email);

}
