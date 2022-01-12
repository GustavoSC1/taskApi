package com.gustavo.taskApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.taskApi.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
