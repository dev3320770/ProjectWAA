package com.mum.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Column(name = "id")
	private long id;

	@NotNull(message = "{NotNull.err}")
	private long studId;
	// private long studentId;
	@NotNull(message = "{NotNull.err}")
	private long sessId;
	// private long sessionId;
	@NotNull(message = "{NotNull.err}")
	private LocalDate checkinDate;
	@NotEmpty(message = "{NotEmpty.err}")
	private String amORpm;
	@NotEmpty(message = "{NotEmpty.err}")
	private String location;
	@NotEmpty(message = "{NotEmpty.err}")
	private String fullStudentName;

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

//	public long getStudentId() {
//		return studentId;
//	}
//
//	public void setStudentId(long studentId) {
//		this.studentId = studentId;
//	}
//
//public long getSessionId() {
//		return sessionId;
//	}
//
//	public void setSessionId(long sessionId) {
//		this.sessionId = sessionId;
//	}

	public LocalDate getCheckinDate() {
		return checkinDate;
	}

	public long getStudId() {
		return studId;
	}

	public void setStudId(long studId) {
		this.studId = studId;
	}

	public long getSessId() {
		return sessId;
	}

	public void setSessId(long sessId) {
		this.sessId = sessId;
	}

	public void setCheckinDate(LocalDate checkinDate) {
		this.checkinDate = checkinDate;
	}

	public String getAmORpm() {
		return amORpm;
	}

	public void setAmORpm(String amORpm) {
		this.amORpm = amORpm;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFullStudentName() {
		return fullStudentName;
	}

	public void setFullStudentName(String fullStudentName) {
		this.fullStudentName = fullStudentName;
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

}
