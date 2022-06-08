package com.app.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.TaskDao;
import com.app.dao.UserDao;
import com.app.dto.TaskDto;
import com.app.exceptions.ResourceNotFoundException;
import com.app.pojos.Task;
import com.app.pojos.Users;

@Service
@Transactional
public class TaskServiceImpl implements ITaskService {

	@Autowired
	private TaskDao taskDao;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserDao userDao;
	
	
	
	@Override
	public TaskDto createTask(TaskDto taskDto, Integer userId) {
		Users user = this.userDao.findById(userId)
		.orElseThrow(()->new ResourceNotFoundException("User", "User id", userId));
		
		Task task= this.modelMapper.map(taskDto, Task.class);
		task.setAssignedDate(new Date());
		task.setTentativeDate(new Date());
		task.setUser(user);
		
		Task newTask = this.taskDao.save(task);
		
		return this.modelMapper.map(newTask, TaskDto.class);
	}

	@Override
	public TaskDto updateTask(TaskDto task, Integer taskId) {
		
		return null;
	}

	@Override
	public void deleteTask(Integer taskId) {
	

	}

	@Override
	public TaskDto getAllTask() {
		
		return null;
	}

	@Override
	public TaskDto getTaskById(Integer taskId) {
	
		return null;
	}

	@Override
	public List<TaskDto> getTaskAssignedToUser(Integer userId) {
	Users user = this.userDao.findById(userId)
			.orElseThrow(()->new ResourceNotFoundException("User", "user id", userId));
	List<Task> tasks = this.taskDao.findByUser(user);
	List<TaskDto> taskDtos = tasks.stream().map((task) -> this.modelMapper.map(task, TaskDto.class))
			.collect(Collectors.toList());
		
		return taskDtos;
	}

}
