package com.mum.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class Session {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private long id;	
	    @NotNull(message = "{NotNull.err}")
	    private Date sessionDate;
	    @NotNull(message = "{NotNull.err}")
	    private Date sessionStartTime;
	    @NotNull(message = "{NotNull.err}")
	    private Date sessionEndTime;
	    @NotEmpty(message = "{NotEmpty.err}")
	    private SessionType sessionType;
	    
	  //  @OneToMany(cascade=CascadeType.ALL)
	   // @Fetch(FetchMode.JOIN)	 
	   // private SessionTransaction sessionTransaction;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Date getSessionDate() {
			return sessionDate;
		}

		public void setSessionDate(Date sessionDate) {
			this.sessionDate = sessionDate;
		}

		public Date getSessionStartTime() {
			return sessionStartTime;
		}

		public void setSessionStartTime(Date sessionStartTime) {
			this.sessionStartTime = sessionStartTime;
		}

		public Date getSessionEndTime() {
			return sessionEndTime;
		}

		public void setSessionEndTime(Date sessionEndTime) {
			this.sessionEndTime = sessionEndTime;
		}

		public SessionType getSessionType() {
			return sessionType;
		}

		public void setSessionType(SessionType sessionType) {
			this.sessionType = sessionType;
		}

//		public SessionTransaction getSessionTransaction() {
//			return sessionTransaction;
//		}
//
//		public void setSessionTransaction(SessionTransaction sessionTransaction) {
//			this.sessionTransaction = sessionTransaction;
//		}
	    
	    
	    
	    
	    
}
