package com.example.employe.service;

import org.springframework.stereotype.Service;

import com.example.employe.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepo;
	
	public UserService(UserRepository x) {
		super();
        this.userRepo = x;
    }
}
