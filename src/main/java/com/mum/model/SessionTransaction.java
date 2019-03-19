package com.mum.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class SessionTransaction {	
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;	
	   
	   @NotNull(message = "{NotNull.err}")
	    private long studentId;
	   @NotNull(message = "{NotNull.err}")
	    private long sessionId;
	   @NotNull(message = "{NotNull.err}")
	    private Date checkinDate;
	   @NotEmpty(message = "{NotEmpty.err}")
	    private String amORpm;
	   @NotEmpty(message = "{NotEmpty.err}")
	    private String location;
	   @NotEmpty(message = "{NotEmpty.err}")
	    private String fullStudentName;
		public long getStudentId() {
			return studentId;
		}
		public void setStudentId(long studentId) {
			this.studentId = studentId;
		}
		public long getSessionId() {
			return sessionId;
		}
		public void setSessionId(long sessionId) {
			this.sessionId = sessionId;
		}
		public Date getCheckinDate() {
			return checkinDate;
		}
		public void setCheckinDate(Date checkinDate) {
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
}
