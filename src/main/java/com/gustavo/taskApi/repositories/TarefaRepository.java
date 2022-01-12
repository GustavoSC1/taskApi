package com.gustavo.taskApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.taskApi.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}