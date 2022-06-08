package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.dto.TaskDto;
import com.app.pojos.Task;
import com.app.pojos.Users;

public interface TaskDao extends JpaRepository<Task, Integer>{

	List<Task> findByUser(Users user);
	
	//@Query("select p from Post p where p.title like :key")
	//List<Task> searchByTitle(@Param("key") String title);
	
}
