package com.mum.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	private long demoID;
	
	@NotEmpty(message = "{NotEmpty.err}")
	private String firstName;
	
	@NotEmpty(message = "{NotEmpty.err}")
	private String lastName;
	@Column(name = "email")
	@Email(message = "{Email.err}")
	private String email;
	
	@Column(name = "title")
	@NotEmpty(message = "{NotEmpty.err}")
	private String title;
	
	@OneToOne(mappedBy = "faculty",	cascade = CascadeType.ALL)
	private Course course;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",    nullable = false)
    private User user_faculty;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getDemoID() {
		return demoID;
	}

	public void setDemoID(long demoID) {
		this.demoID = demoID;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public User getUser_faculty() {
		return user_faculty;
	}

	public void setUser_faculty(User user_faculty) {
		this.user_faculty = user_faculty;
	}
	
	
	

}
