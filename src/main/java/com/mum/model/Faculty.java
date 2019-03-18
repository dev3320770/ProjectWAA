package com.mum.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")	
	@NotEmpty(message = "{NotEmpty.err}")
	private String name;
	
	@Column(name = "email")
	@Email(message = "{Email.err}")
	private String email;
	
	@Column(name = "title")
	@NotEmpty(message = "{NotEmpty.err}")
	private String title;

}
