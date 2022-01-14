package com.gustavo.taskApi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gustavo.taskApi.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	@Query("select obj from Task obj where upper(obj.description) LIKE '%' || upper(:filter) || '%'")
	Page<Task> findByDescription(@Param("filter") String filter, Pageable pageable);

}
