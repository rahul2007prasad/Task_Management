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
	public TaskDto updateTask(TaskDto taskDto, Integer taskId) {
		
		Task task = this.taskDao.findById(taskId)
				.orElseThrow(() -> new ResourceNotFoundException("Task", "Task Id", taskId));
		task.setAssignedBy(taskDto.getAssignedBy());
		task.setAssignedTo(taskDto.getAssignedTo());
		task.setAssignedDate(taskDto.getAssignedDate());
		task.setTentativeDate(taskDto.getTentativeDate());
		task.setCategory(taskDto.getCategory());
		task.setComment(taskDto.getComment());
		task.setDescription(taskDto.getDescription());
		task.setRemark(taskDto.getRemark());
		task.setStatus(taskDto.getStatus());
		task.setTitle(taskDto.getTitle());
		
		Task updateTask = this.taskDao.save(task);
		return this.modelMapper.map(updateTask, TaskDto.class);
		
		
		
		
	}

	@Override
	public void deleteTask(Integer taskId) {
	Task task = this.taskDao.findById(taskId)
			.orElseThrow(()-> new ResourceNotFoundException("Task", "Task Id", taskId));
		this.taskDao.delete(task);
	}

	@Override
	public List<TaskDto> getAllTask() {
		List<Task> allTasks = this.taskDao.findAll();
		List<TaskDto> taskDtos =allTasks.stream().map((task) ->this.modelMapper.map(task, TaskDto.class))
				.collect(Collectors.toList());
		
		
		return taskDtos;
	}

	//get task by task id
	@Override
	public TaskDto getTaskById(Integer taskId) {
	Task task = this.taskDao.findById(taskId)
			.orElseThrow(()-> new ResourceNotFoundException("Task", "Task Id", taskId));
	
		return this.modelMapper.map(task, TaskDto.class);
	}

	//get task by user id
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
