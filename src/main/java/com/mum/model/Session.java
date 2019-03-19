package com.mum.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	    @Column(name = "session_id")
	    private long id;	
//	    @NotNull(message = "{NotNull.err}")
	    private LocalDate sessionDate;
//	    @NotNull(message = "{NotNull.err}")
	    private LocalDateTime sessionStartTime;  
//	    @NotNull(message = "{NotNull.err}")
//	    private LocalDate sessionEndTime;
	    private SessionType sessionType;
	    
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "block_id")
	    private Block block;
	    
	   // @OneToMany(cascade=CascadeType.ALL)
	   // @Fetch(FetchMode.JOIN)	 
	   // private SessionTransaction sessionTransaction;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public LocalDate getSessionDate() {
			return sessionDate;
		}

		public void setSessionDate(LocalDate sessionDate) {
			this.sessionDate = sessionDate;
		}

		public LocalDateTime getSessionStartTime() {
			return sessionStartTime;
		}

		public void setSessionStartTime(LocalDateTime sessionStartTime) {
			this.sessionStartTime = sessionStartTime;
		}

//		public LocalDate getSessionEndTime() {
//			return sessionEndTime;
//		}
//
//		public void setSessionEndTime(LocalDate sessionEndTime) {
//			this.sessionEndTime = sessionEndTime;
//		}

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
		
		public void setSessionBlock(Block block) {
			this.block = block;
		}
		
		public Block getSessionBlock() {
			return this.block;
		}
		
		public String toString() {
			return "[id: " + id + 
					" sessionDate: " + sessionDate + 
					" sessionStartTime: " + sessionStartTime 
					+ "sessionType: " + sessionType + 
					"block: " + block.getId() + "]"; 
		}
	    
		public static class SessionBuilder {
			private Session session;
			
			public SessionBuilder() {
				session = new Session();
			}
			
			public SessionBuilder withId(Long id) {
				session.setId(id);
				return this;
			}
			
			public SessionBuilder withDate(LocalDate sessionDate) {
				session.setSessionDate(sessionDate);
				return this;
			}
			
			public SessionBuilder withStartTime(LocalDateTime sessionStartTime) {
				session.setSessionStartTime(sessionStartTime);
				return this;
			}
			
//			public SessionBuilder withEndTime(LocalDate sessionEndTime) {
//				session.setSessionEndTime(sessionEndTime);
//				return this;
//			}
			
			public SessionBuilder withType(SessionType type) {
				session.setSessionType(type);
				return this;
			}
			
			public SessionBuilder inBlock(Block block) {
				session.setSessionBlock(block);
				return this;
			}
			
			public Session build() {
				return session;
			}

			public SessionBuilder withBlock(Block block) {
				// TODO Auto-generated method stub
				return null;
			}
			
		}	    
}
