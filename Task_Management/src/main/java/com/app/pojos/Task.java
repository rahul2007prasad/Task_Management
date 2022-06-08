package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task extends BaseEntity{

	public Task() {
		System.out.println("In constr of "+getClass().getName());
	}
	
	@Column(name="title" , length=30)
	private String title;
	
	@Column(name="description" , length=30)
	private String description;
	
	@Column(name="category" , length=30)
	private String category;
	
	@Column(name="status" , length=30)
	private String status;
	
	@Column(name="assigned_by" , length=30)
	private String assignedBy;
	
	@Column(name="assigned_to" , length=30)
	private String assignedTo;
	
	@Column(name="assigned_date" , length=30)
	private Date assignedDate;
	
	@Column(name="tentative_date" , length=30)
	private Date tentativeDate;
	
	@Column(name="remark" , length=30)
	private String remark;
	
	@Column(name="comment" , length=30)
	private String comment;
	
	
	@ManyToOne
	private Users user;


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


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
