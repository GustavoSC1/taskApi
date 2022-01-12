package com.gustavo.taskApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.taskApi.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
