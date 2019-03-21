package com.mum.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Block implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -1690395162386988097L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;


	private LocalDate startDate;

	private LocalDate endDate;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Session> sessions;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Course> courses;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

<<<<<<< HEAD
	public void addSession(Session session) {
		// TODO Auto-generated method stub
		this.sessions.add(session);
		
	}	
=======
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	
	
>>>>>>> master
	
	
}
