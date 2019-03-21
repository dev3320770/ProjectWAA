package com.mum.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Entity
public class Course implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -6251239061685918298L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	//@NotEmpty(message = "{NotEmpty.err}")
	private String code;
	
	//@NotEmpty(message = "{NotEmpty.err}")
	private String name;
	
	//@NotEmpty(message = "{NotEmpty.err}")
	private String description;
	
	//@Valid
	@ManyToOne
	private Block block;

	//@Valid
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Faculty> faculty;

	//@Valid
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Student> students;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}



	public List<Faculty> getFaculty() {
		return faculty;
	}

	public void setFaculty(List<Faculty> faculty) {
		this.faculty = faculty;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

}
