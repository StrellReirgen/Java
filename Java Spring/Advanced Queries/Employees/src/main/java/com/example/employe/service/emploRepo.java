package com.example.employe.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.employe.models.Employees;
import com.example.employe.repository.UserRepository;

@Service
public class emploRepo {
	private static UserRepository repositoryU;

	public static Employees findOne(Long valueOf) {
		// TODO Auto-generated method stub
		Optional<Employees> o = repositoryU.findById(valueOf);
		return o.get();
	}

}
