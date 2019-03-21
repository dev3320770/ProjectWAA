package com.mum.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity

public class Student implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 8485169243133898497L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String studentId;

	@NotEmpty(message = "{NotEmpty.err}")
	private String firstName;
	
	@NotEmpty(message = "{NotEmpty.err}")
	private String lastName;
	
	@NotNull(message = "{NotNull.err}")
	private LocalDate entryDate;
	
	@Email
	private String email;


	@ManyToMany
	private List<Course> course;

	@Valid
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Course> courses;


	//@Valid
	@OneToMany(cascade = CascadeType.ALL)
	private List<SessionTransaction> sessionTransactions;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	public List<SessionTransaction> getSessionTransactions() {
		return sessionTransactions;
	}

	public void setSessionTransactions(List<SessionTransaction> sessionTransactions) {
		this.sessionTransactions = sessionTransactions;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addSessionTransaction(SessionTransaction sessionTransaction) {
		this.sessionTransactions.add(sessionTransaction);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", entryDate=" + entryDate + ", email=" + email + ", course=" + course + ", sessionTransactions="
				+ sessionTransactions + ", user=" + user + "]";
	}
	
	

}
