package com.strell.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/pass", method=RequestMethod.POST)
    public String login(@RequestParam(value="respuesta") String respuesta) {
		if (respuesta.equals("bushido") || respuesta.equals("Bushido")) {
			return "redirect:/code";
		} else {
			return "redirect:/bad";
		}
	}
	
	@RequestMapping("/bad")
	public String flashMessages(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "¡Muy mal, necesitas mas entrenamiento!");
        return "redirect:/";
	}
	
	@RequestMapping("/code")
	public String code() {
		return "code.jsp";
	}
}
