package com.example.employe.controller;

import org.springframework.stereotype.Controller;

import com.example.employe.service.UserService;

@Controller
public class MainController {
	private final UserService service;

	public MainController(UserService service) {
		super();
		this.service = service;
	}


}
