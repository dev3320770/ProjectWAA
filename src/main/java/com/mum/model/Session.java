package com.mum.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;

public class Session {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private long id;	  
	    private Date sessionDate;
	    private Date sessionStartTime;
	    private Date sessionEndTime;
	    private SessionType sessionType;
	    

}
