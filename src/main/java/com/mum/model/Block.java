package com.mum.model;

import java.time.LocalDate;
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
	    @Column(name = "block_id")
	    private long id;
	    @NotEmpty(message = "{NotEmpty.err}")
	    private String name;
	    private String description;	
	    @NotNull(message = "{NotNull.err}")
	    private LocalDate startDate;	    
	    @NotNull(message = "{NotNull.err}")
	    private LocalDate endDate;	   
	    
	    @Valid
	    @OneToMany(cascade=CascadeType.ALL, mappedBy="block")
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
		public LocalDate getStartDate() {
			return startDate;
		}
		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}
		public LocalDate getEndDate() {
			return endDate;
		}
		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
		}
		public List<Session> getSessions() {
			return sessions;
		}
		public void setSessions(List<Session> sessions) {
			this.sessions = sessions;
			for(Session session : sessions) {
				session.setSessionBlock(this);
			}
		}
		
		public static class BlockBuilder {
			private Block block;
			
			public BlockBuilder() {
				block = new Block();
			}
			
			public BlockBuilder withId(Long id) {
				block.setId(id);
				return this;
			}
			
			public BlockBuilder withName(String name) {
				block.setName(name);
				return this;
			}
			
			public BlockBuilder withDescription(String description) {
				block.setDescription(description);
				return this;
			}
			
			public BlockBuilder withStartDate(LocalDate startDate) {
				block.setStartDate(startDate);
				return this;
			}
			
			public BlockBuilder withEndDate(LocalDate endDate) {
				block.setEndDate(endDate);
				return this;
			}
			
			public BlockBuilder withSessions(List<Session> sessions) {
				block.setSessions(sessions);
				return this;
			}
			
			public Block build() {
				return block;
			}
		}

}
