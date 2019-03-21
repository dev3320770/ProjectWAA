package com.mum.exception;

public class AttendanceRowException extends RuntimeException {

	private static final long serialVersionUID = 3935230281455340039L;

	private String checkinDate;

	public AttendanceRowException(String checkinDate) {
		this.checkinDate = checkinDate;
	}

	public String getCheckinDate() {
		return checkinDate;
	}

}
