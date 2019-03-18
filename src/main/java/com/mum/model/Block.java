package com.mum.model;

import java.sql.Date;
import java.util.List;

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
public class Block {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private long id;	  
	    private String name;
	    private String description;	    
	    private Date startDate;	    
	    private Date endDate;	   
	    @Valid
	    @OneToMany(cascade=CascadeType.ALL)
	    private long id;
	    @NotEmpty(message = "{NotEmpty.err}")
	    private String name;
	    private String description;	
	    @NotNull(message = "{NotNull.err}")
	    private Date startDate;	    
	    @NotNull(message = "{NotNull.err}")
	    private Date endDate;	   
	    @Valid
	    @OneToMany(cascade=CascadeType.ALL)
	    @Fetch(FetchMode.JOIN)	  
	    private List<Session> sessions;
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		public List<Session> getSessions() {
			return sessions;
		}
		public void setSessions(List<Session> sessions) {
			this.sessions = sessions;
		}

}
