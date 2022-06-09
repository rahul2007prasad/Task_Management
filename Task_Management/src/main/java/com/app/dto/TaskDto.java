package com.app.dto;

import java.sql.Date;

import javax.persistence.Column;

import com.app.pojos.BaseEntity;

public class TaskDto extends BaseEntity{

	public TaskDto() {
		System.out.println("In constr of "+getClass().getName());
	}
	
	
	
	private String title;
	
	
	private String description;
	

	private String category;
	
	
	private String status;
	
	
	private String assignedBy;
	
	
	private String assignedTo;
	
	
	private Date assignedDate;
	
	
	private Date tentativeDate;
	
	
	private String remark;
	
	
	private String comment;
	
	private LoginRequest userDto;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public Date getTentativeDate() {
		return tentativeDate;
	}

	public void setTentativeDate(Date tentativeDate) {
		this.tentativeDate = tentativeDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LoginRequest getUserDto() {
		return userDto;
	}

	public void setUserDto(LoginRequest userDto) {
		this.userDto = userDto;
	}
	
	
	
	
	
	
}
