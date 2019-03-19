package com.mum.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Session implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4521270593985598780L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	private long demoID;

	@NotNull(message = "{NotNull.err}")
	private LocalDate sessionDate;
	@NotNull(message = "{NotNull.err}")
	private LocalDateTime sessionStartTime;
	@NotNull(message = "{NotNull.err}")
	private LocalDateTime sessionEndTime;
	@NotEmpty(message = "{NotEmpty.err}")
	private SessionType sessionType;

	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id", nullable = false)
	private Location location;

	@ManyToOne
	private Block block;

	@Valid
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	private Set<SessionTransaction> sessionTransactions;

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

	public LocalDateTime getSessionEndTime() {
		return sessionEndTime;
	}

	public void setSessionEndTime(LocalDateTime sessionEndTime) {
		this.sessionEndTime = sessionEndTime;
	}

	public SessionType getSessionType() {
		return sessionType;
	}

	public void setSessionType(SessionType sessionType) {
		this.sessionType = sessionType;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public Set<SessionTransaction> getSessionTransactions() {
		return sessionTransactions;
	}

	public void setSessionTransactions(Set<SessionTransaction> sessionTransactions) {
		this.sessionTransactions = sessionTransactions;
	}

	public void addSessionTransaction(SessionTransaction sessionTransaction) {
		this.sessionTransactions.add(sessionTransaction);
	}

}
