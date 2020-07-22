package com.example.authentication.controller;

import javax.servlet.http.HttpSession;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.authentication.models.User;
import com.example.authentication.service.UserService;

@Controller
public class Users {
private final UserService userService;
    
    public Users(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	if (result.hasErrors()) {
    		return "redirect:/registration";
    	
    	}else {
    		userService.registerUser(user);
    		return "redirect:/login";
    	}
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
    	Boolean key = userService.authenticateUser(email, password);
    	if (key) {
    		User a = userService.findByEmail(email);
    		session.setAttribute("userid", a.getId());
    		return "redirect:/home";
    	}else {
    		model.addAttribute("error", "Datos Invalidos, Permiso Denegado");
    		return "loginPage.jsp";
    	}
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
    	Long id = (Long) session.getAttribute("userid");
    	User a = userService.findUserById(id);
    	model.addAttribute("user", a);
    	return "homePage.jsp";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
    	return "redirect:/login";
    }
}
