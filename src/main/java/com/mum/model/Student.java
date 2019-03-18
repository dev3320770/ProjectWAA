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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class Student {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "studentId")
	    private long id;	
	    @NotEmpty(message = "{NotEmpty.err}")
	    private String firstName;
	    @NotEmpty(message = "{NotEmpty.err}")
	    private String lastName;	
	    @NotNull(message = "{NotNull.err}")	  
	    private Date entryDate;	    
	    @Email
	    private String email;	
	    @Valid
	    @OneToMany(cascade=CascadeType.ALL)
        List<Block> blocks;
		public long getId() {
			return id;
		}
		public void setId(long id) {
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
		public Date getEntryDate() {
			return entryDate;
		}
		public void setEntryDate(Date entryDate) {
			this.entryDate = entryDate;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public List<Block> getBlocks() {
			return blocks;
		}
		public void setBlocks(List<Block> blocks) {
			this.blocks = blocks;
		}
	
	

}
