package com.strell.repaso.service;

import org.springframework.stereotype.Service;

import com.strell.repaso.models.Coment;
import com.strell.repaso.repository.ComentRepository;

@Service
public class ComentService {
	private final ComentRepository comentRepo;
	
	public ComentService (ComentRepository a) {
		this.comentRepo = a;
	}
	public Coment createComent(Coment a) {
		return comentRepo.save(a);
	}
}
