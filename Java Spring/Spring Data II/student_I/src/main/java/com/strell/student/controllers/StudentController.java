package com.strell.student.controllers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.strell.student.models.Contact;
import com.strell.student.models.Student;
import com.strell.student.services.ContactService;
import com.strell.student.services.StudentService;

@Controller
public class StudentController {
	private final StudentService StudentServ;
	private final ContactService ContactServ;
	public StudentController(StudentService a, ContactService b){
        this.StudentServ = a;
        this.ContactServ = b;
    }
	@RequestMapping("/")
    public String index() {
        return "/index.jsp";
    }
	@RequestMapping(value="/students/{id}", method=RequestMethod.DELETE)
    public String destroyNinja(@PathVariable("id") Long id) {
		Student user = StudentServ.findStudent(id);
		ContactServ.deleteContact(user.getContact().getId());
		StudentServ.deleteStudent(id);
		return "redirect:/students";
    }
	@RequestMapping("/students")
    public String listStudent(Model model) {
		List<Student> users = StudentServ.allStudent();
		model.addAttribute("lista", users);
        return "/students/list.jsp";
    }
	@RequestMapping("/students/new")
    public String newStudent() {
        return "/students/news.jsp";
    }
	@RequestMapping(value="/students/new", method=RequestMethod.POST)
    public String createStudent(@RequestParam("name") String nombre, @RequestParam("lastname") String apellido, @RequestParam("age") Integer edad) {
		Student user = new Student(nombre, apellido, edad);
        StudentServ.createStudent(user);
		return "redirect:/students";
    }
	@RequestMapping("/contact/new")
    public String newContact(Model model) {
		List<Student> users = StudentServ.allStudent();
		model.addAttribute("lista", users);
        return "/contact/newc.jsp";
    }
	@RequestMapping(value="/contact/new", method=RequestMethod.POST)
    public String createContact(@RequestParam(value="user") Long id, @RequestParam(value="city") String ciudad, @RequestParam(value="address") String direccion, @RequestParam(value="state") String estado) {
		Student user = StudentServ.findStudent(id);
		Contact contacto= new Contact(ciudad, direccion, estado, user);
		ContactServ.createContact(contacto);
		return "redirect:/students";
    }
}
