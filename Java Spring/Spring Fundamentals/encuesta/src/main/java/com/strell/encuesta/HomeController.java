package com.strell.encuesta;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	@RequestMapping(value="/info", method=RequestMethod.POST)
    public String login(HttpSession session, @RequestParam(value="name") String name, @RequestParam(value="place") String place, @RequestParam(value="lenguaje") String lenguaje, @RequestParam(value="message") String message) { 
		if (name.equals("")) {
			session.setAttribute("name", "Anonimo");	
		} else {
			session.setAttribute("name", name);
		}
		if (message.equals("")) {
			session.setAttribute("message", "Nada que decir");	
		} else {
			session.setAttribute("message", message);
		}
		session.setAttribute("place", place);
		session.setAttribute("lenguaje", lenguaje);
		if(lenguaje.equals("Java")) {
			return "redirect:/java";
		} else {
			return "redirect:/result";
		}
		
		
	}
	@RequestMapping("/java")
	public String java(HttpSession session) {
		return "java.jsp";
	}
	@RequestMapping("/result")
	public String result(HttpSession session) {
		return "result.jsp";
	}
}
