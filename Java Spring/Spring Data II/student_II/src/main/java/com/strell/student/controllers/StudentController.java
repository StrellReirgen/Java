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
import com.strell.student.models.Room;
import com.strell.student.models.Student;
import com.strell.student.services.ContactService;
import com.strell.student.services.RoomService;
import com.strell.student.services.StudentService;

@Controller
public class StudentController {
	private final StudentService StudentServ;
	private final ContactService ContactServ;
	private final RoomService RoomServ;
	public StudentController(StudentService a, ContactService b, RoomService c){
        this.StudentServ = a;
        this.ContactServ = b;
        this.RoomServ = c;
    }
	@RequestMapping("/")
    public String index(Model model) {
		List<Room> room = RoomServ.allRoom();
		model.addAttribute("lugar", room);
        return "/index.jsp";
    }
	@RequestMapping(value="/students/{id}", method=RequestMethod.DELETE)
    public String destroyStudent(@PathVariable("id") Long id) {
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
	@RequestMapping("/room/new")
    public String newRoom() {
        return "/room/newr.jsp";
    }
	@RequestMapping(value="/room/new", method=RequestMethod.POST)
    public String createRoom(@RequestParam("room") String cuarto) {
		List<Student> user = new ArrayList<Student>();
		Room lugar= new Room(cuarto, user);
        RoomServ.createRoom(lugar);
		return "redirect:/";
    }
	@RequestMapping("/room/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
		Room place = RoomServ.findRoom(id);
		List<Student> users = StudentServ.allStudent();
		model.addAttribute("lista", users);
        model.addAttribute("room", place);
        return "/room/room.jsp";
    }
	@RequestMapping(value="/room/{id}", method=RequestMethod.PUT)
    public String updateRoom(@PathVariable("id") Long id, @RequestParam("user") Long user) {
		Room place = RoomServ.findRoom(id);
		Student usuario = StudentServ.findStudent(user);
		usuario.setRoom(place);
		StudentServ.roomingStudent(usuario);
		return "redirect:/room/"+place.getId();
    }
	@RequestMapping(value="/room/{rid}/{sid}", method=RequestMethod.DELETE)
    public String dropStudent(@PathVariable("rid") Long room, @PathVariable("sid") Long user) {
		Student usuario = StudentServ.findStudent(user);
		usuario.setRoom(null);
		StudentServ.roomingStudent(usuario);
		return "redirect:/room/"+room;
    }
	@RequestMapping(value="/room/{id}", method=RequestMethod.DELETE)
    public String destroyRoom(@PathVariable("id") Long id) {
		RoomServ.deleteRoom(id);
		return "redirect:/students";
    }
}
