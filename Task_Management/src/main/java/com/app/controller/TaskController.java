package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.TaskDto;
import com.app.service.ITaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private ITaskService taskService;
	
	//create task
	
	@PostMapping("/user/{userId}/tasks")
	public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto ,@PathVariable Integer userId){
		TaskDto createTask = this.taskService.createTask(taskDto, userId);
		return new ResponseEntity<TaskDto>(createTask,HttpStatus.CREATED);
	}
	
	//get task by employee or user
	
	@GetMapping("/user/{userId}/tasks")
	public ResponseEntity<List<TaskDto>> getTaskByEmployee(@PathVariable Integer userId){
		List<TaskDto> tasks = this.taskService.getTaskAssignedToUser(userId);
		
		return new ResponseEntity<List<TaskDto>>(tasks,HttpStatus.OK);
	}
	
	
	
	
}
