package com.strell.holahumano;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaHumanoController {
	@RequestMapping("/")
    public String index(@RequestParam(value="name", required=false) String nombre, @RequestParam(value="lastname", required=false) String apellido) {
        if (nombre == null || apellido == null) {
        	return "Hola Humano";
        } else {
        	return "Hola " + nombre + " " + apellido;
        }
    }

}
