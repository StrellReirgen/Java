package com.strell.student.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.strell.student.models.Contact;
import com.strell.student.models.Student;
import com.strell.student.services.ContactService;
import com.strell.student.services.StudentService;

@RestController
public class DriverApi {
	private final StudentService StudentServ;
	private final ContactService ContactServ;
	public DriverApi(StudentService a, ContactService b){
        this.StudentServ = a;
        this.ContactServ = b;
    }
	@RequestMapping("/api/student")
    public List<Student> indexA() {
        return StudentServ.allStudent();
    }
	
	@RequestMapping(value="/api/student", method=RequestMethod.POST)
    public Student createP(@RequestParam(value="firstName") String nombre, @RequestParam(value="lastName") String apellido, @RequestParam(value="age") Integer edad) {
		Student user = new Student(nombre, apellido, edad);
        return StudentServ.createStudent(user);
    }
	@RequestMapping("/api/student/{id}")
    public Student showP(@PathVariable("id") Long id) {
        return StudentServ.findStudent(id);
    }
	@RequestMapping(value="/api/student/{id}", method=RequestMethod.PUT)
    public Student updateP(@PathVariable("id") Long id, @RequestParam(value="firstName") String nombre, @RequestParam(value="lastName") String apellido, @RequestParam(value="age") Integer edad) {
		Student user = StudentServ.findStudent(id);
        user.setFirstName(nombre);
        user.setlastName(apellido);
        user.setAge(edad);
        return StudentServ.updateStudent(user);
    }
	@RequestMapping(value="/api/student/{id}", method=RequestMethod.DELETE)
    public void destroyP(@PathVariable("id") Long id) {
		StudentServ.deleteStudent(id);
    }
	
	@RequestMapping("/api/contact")
    public List<Contact> indexB() {
        return ContactServ.allContact();
    }
	@RequestMapping(value="/api/contact", method=RequestMethod.POST)
    public Contact createL(@RequestParam(value="user") Long id, @RequestParam(value="city") String ciudad, @RequestParam(value="address") String direccion, @RequestParam(value="state") String estado) {
		Student user = StudentServ.findStudent(id);
		Contact contacto= new Contact(ciudad, direccion, estado, user);
        return ContactServ.createContact(contacto);
    }
	@RequestMapping("/api/contact/{id}")
    public Contact showL(@PathVariable("id") Long id) {
        return ContactServ.findContact(id);
    }
	@RequestMapping(value="/api/contact/{id}", method=RequestMethod.PUT)
    public Contact updateL(@PathVariable("id") Long id, @RequestParam(value="city") String ciudad, @RequestParam(value="address") String direccion, @RequestParam(value="state") String estado) {
		Contact user = ContactServ.findContact(id);
        user.setCity(ciudad);
    	user.setAddress(direccion);
    	user.setState(estado);
        return ContactServ.updateContact(user);
    }
	@RequestMapping(value="/api/contact/{id}", method=RequestMethod.DELETE)
    public void destroyL(@PathVariable("id") Long id) {
		ContactServ.deleteContact(id);
    }
}
