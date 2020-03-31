package com.strell.enrutamiento;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("/{track}")
    public String showLesson(@PathVariable ("track") String track){
		if (track.equals("dojo")) {
			return "¡El Dojo es increíble!";
		} else if (track.equals("burbank-dojo")) {
			return "El Dojo Burbank está localizado al sur de California";
		} else if (track.equals("san-jose")) {
			return "El Dojo SJ es el cuartel general";
		} else {
			System.out.print(track);
			return "No has colocado una ruta valida, eliga un path: /coding, /coding/javascript, /coding/java, /dojo, /burbank-dojo, /san-jose ";
		}
		
    }
}
