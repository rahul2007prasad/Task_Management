package com.app.service;

import java.util.List;

import com.app.dto.TaskDto;
import com.app.pojos.Task;

public interface ITaskService {
	
	//create
	TaskDto createTask(TaskDto task,Integer userId);
	
	//update
	TaskDto updateTask(TaskDto task , Integer taskId);
	
	//delete
	void deleteTask(Integer taskId);
	
	//get all task
	
	List<TaskDto> getAllTask();
	
	//get single task
	TaskDto getTaskById(Integer taskId);
	
	//get all post by employees
	
	List<TaskDto>  getTaskAssignedToUser(Integer userId);
	
	

}
