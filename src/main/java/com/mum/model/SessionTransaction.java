package com.mum.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SessionTransaction {
	 
	   
	    private long studentId;
	    private long sessionId;
	    private Date checkinDate;
	    private String amORpm;
	    private String location;
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
