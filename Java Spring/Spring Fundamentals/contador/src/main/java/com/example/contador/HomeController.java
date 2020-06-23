package com.example.contador;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(HttpSession session) {
        String contador = (String) session.getAttribute("count");
        Integer numero;
        
        if (contador == null) {
        	session.setAttribute("count", "1");
        } else {
        	numero = Integer.parseInt(contador);
        	numero ++;
        	contador = numero.toString();
        	session.setAttribute("count", contador);
        }
        
        return "index.jsp";	
    }
	
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		String contador = (String) session.getAttribute("count");
        
		if (contador == null) {
        	session.setAttribute("count", "0");
        	
        }
		
        return "counter.jsp";	
    }
	
	@RequestMapping("/doble")
	public String doble(HttpSession session) {
		String contador = (String) session.getAttribute("count");
        Integer numero;
        
        if (contador == null) {
        	session.setAttribute("count", "2");
        } else {
        	numero = Integer.parseInt(contador);
        	numero += 2;
        	contador = numero.toString();
        	session.setAttribute("count", contador);
        }
        
        return "doble.jsp";	
    }

}
