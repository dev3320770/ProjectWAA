package com.mum.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class Faculty implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7732998540875682657L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	//@NotEmpty(message = "{NotEmpty.err}")
	private String firstName;

	//@NotEmpty(message = "{NotEmpty.err}")
	private String lastName;
	
	//@Email(message = "{Email.err}")
	private String email;


	@ManyToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
	private List<Course> course;

	@OneToOne(cascade =	CascadeType.ALL)
	@JoinColumn(name = "user_id",nullable = false)

	private User user;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



}
