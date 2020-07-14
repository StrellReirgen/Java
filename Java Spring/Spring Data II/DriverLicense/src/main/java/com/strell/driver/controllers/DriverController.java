package com.strell.driver.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.strell.driver.models.License;
import com.strell.driver.models.Person;
import com.strell.driver.services.LicenseService;
import com.strell.driver.services.PersonService;

@Controller
public class DriverController {
	private final PersonService PersonServ;
	private final LicenseService LicenServ;
	public DriverController(PersonService b, LicenseService a){
        this.PersonServ = b;
        this.LicenServ = a;
    }
	@RequestMapping("/")
    public String index(Model model) {
        List<Person> person = PersonServ.allPerson();
        model.addAttribute("user", person);
        return "/index.jsp";
    }
	
	@RequestMapping("/persons/new")
    public String newPerson(@ModelAttribute("dato") Person code) {
        return "/person/newp.jsp";
    }
	@RequestMapping(value="/persons/new", method=RequestMethod.POST)
    public String createPerson(@Valid @ModelAttribute("dato") Person code, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/persons/new";
        } else {
        	PersonServ.createPerson(code);
            return "redirect:/";
        }
    }
	@RequestMapping("/licenses/new")
    public String newLicense(Model model) {
		List<Person> person = PersonServ.allPerson();
        model.addAttribute("users", person);
        return "/license/newl.jsp";
    }
	@RequestMapping(value="/licenses/new", method=RequestMethod.POST)
    public String createLicense(@RequestParam("usuario") Long id, @RequestParam("date") String fecha, @RequestParam("state") String estado) throws ParseException {
		System.out.println("id: "+id);
		System.out.println("region: "+estado);
		System.out.println("date: "+fecha);
		Person user = PersonServ.findPerson(id);
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		License b = new License("", date, estado, user);
		LicenServ.createLicense(b);
        return "redirect:/";
    }
	@RequestMapping("/persons/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
		Person user = PersonServ.findPerson(id);
        model.addAttribute("usuario", user);
        return "/person/show.jsp";
    }
}
