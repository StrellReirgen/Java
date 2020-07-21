package com.strell.countries.controllers;

import java.util.List;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.strell.countries.models.Country;
import com.strell.countries.services.ApiService;

@RestController
public class ApiController {
	private final ApiService ApiServ;
	public ApiController(ApiService d){
        this.ApiServ = d;
    }
	@RequestMapping("/api")
    public List<Object[]> api() {
		return ApiServ.octavaConsulta();
    }
	
}
