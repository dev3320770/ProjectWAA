package com.mum.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class SessionTransaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2586429374881431820L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "{NotNull.err}")
	private LocalDate checkinDate;
	
	@NotEmpty(message = "{NotEmpty.err}")
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;
	

	@ManyToOne
	private Session session;

	@ManyToOne
	private Student student;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(LocalDate checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String toString() {
		String transaction = "";
		String studentId = student.getStudentId();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		transaction += studentId.substring(studentId.length()-4) + ","
					+ session.getSessionDate().format(formatter) + ","
					+ "AM," + location.getName();
		return transaction;
	}

}
