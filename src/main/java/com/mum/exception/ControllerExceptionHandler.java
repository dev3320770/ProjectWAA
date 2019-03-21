package com.mum.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(AttendanceRowException.class)
	public ModelAndView handleError(HttpServletRequest req, AttendanceRowException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidCheckinId", "invalid Date in Attendance Data Heheheeeee");
		mav.addObject("exception", exception);
		//mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
		mav.setViewName("invalidDateTime");
		return mav;
	}

}
