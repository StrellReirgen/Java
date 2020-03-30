package com.strell.cadenas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CadenasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadenasApplication.class, args);
	}
	
	@RequestMapping("/")
	public String hello() {
		return "¡Hola Cliente!, Espero que tenga un buen dia en cuarentena";
	}
	
	@RequestMapping("/random")
	public String spring() {
		return "¡Spring Boot es genial!, Puedes crear sitios mucho mas facil";
	}

}
