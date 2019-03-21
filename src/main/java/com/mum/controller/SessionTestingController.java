package com.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mum.data.init.DataGeneratorService;
import com.mum.model.Session;
import com.mum.service.SessionService;

@Controller
public class SessionTestingController {
	
	@Autowired private SessionService sessionService;
	@Autowired private DataGeneratorService dataGeneratorService;
	
	@GetMapping("/session/getSession/id/{sessionId}")
	public void getSessionByID(@PathVariable Long sessionID) {
		System.out.println(sessionService.findSessionById(sessionID));
	}
	
	@RequestMapping("/sesion/session/block/{blockId}")
	public String getAllSessions(@PathVariable("blockId") Long blockId) {
		System.out.println("festus");
		List<Session> sessions = sessionService.getAllSessionsInBlock(blockId);
		for (Session session : sessions) {
			System.out.println(session);
		}
		return "dashboard";
	}
	
	@RequestMapping("/populate")
	public String populate() {
		dataGeneratorService.initialize();
		System.out.println("DONE DONE DONE DONE DONE");
		return "login";
	}

}
