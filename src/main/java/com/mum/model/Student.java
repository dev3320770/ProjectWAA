package com.mum.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Student {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "studentId")
	    private long id;	
	    private long demoID;
	    @NotEmpty(message = "{NotEmpty.err}")
	    private String code;
	   
		@NotEmpty(message = "{NotEmpty.err}")
	    private String firstName;
	    @NotEmpty(message = "{NotEmpty.err}")
	    private String lastName;	
	    @NotNull(message = "{NotNull.err}")	  
	    private LocalDate entryDate;	    
	    @Email
	    private String email;	
	   
	    @ManyToOne
	    private Course course;
	    
	    @Valid
	    @LazyCollection(LazyCollectionOption.FALSE)
	    @OneToMany(cascade=CascadeType.ALL)
	    @Fetch(FetchMode.JOIN)	  
	    private Set<SessionTransaction> sessionTransactions ;
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "user_id",
	    nullable = false)
	    private User user_student;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public long getDemoID() {
			return demoID;
		}

		public void setDemoID(long demoID) {
			this.demoID = demoID;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
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

		public LocalDate getEntryDate() {
			return entryDate;
		}

		public void setEntryDate(LocalDate entryDate) {
			this.entryDate = entryDate;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Course getCourse() {
			return course;
		}

		public void setCourse(Course course) {
			this.course = course;
		}

		public Set<SessionTransaction> getSessionTransactions() {
			return sessionTransactions;
		}

		public void setSessionTransactions(Set<SessionTransaction> sessionTransactions) {
			this.sessionTransactions = sessionTransactions;
		}

		public User getUser_student() {
			return user_student;
		}

		public void setUser_student(User user_student) {
			this.user_student = user_student;
		}
		public void addSessionTransaction(SessionTransaction sessionTransaction) {
			this.sessionTransactions.add(sessionTransaction);
		}
	    
}
