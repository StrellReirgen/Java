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
import com.strell.student.models.Class;
import com.strell.student.services.ClassService;
import com.strell.student.services.ContactService;
import com.strell.student.services.RoomService;
import com.strell.student.services.StudentService;

@Controller
public class StudentController {
	private final StudentService StudentServ;
	private final ContactService ContactServ;
	private final RoomService RoomServ;
	private final ClassService ClassServ;
	public StudentController(StudentService a, ContactService b, RoomService c, ClassService d){
        this.StudentServ = a;
        this.ContactServ = b;
        this.RoomServ = c;
        this.ClassServ = d;
    }
	@RequestMapping("/")
    public String index(Model model) {
		List<Room> room = RoomServ.allRoom();
		model.addAttribute("lugar", room);
		List<Class> materias = ClassServ.allClass();
		model.addAttribute("clases", materias);
        return "/index.jsp";
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
		List<Class> sala = new ArrayList<Class>();
		Student user = new Student(nombre, apellido, edad, sala);
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
	@RequestMapping("/class/new")
    public String newClass() {
        return "/class/newclass.jsp";
    }
	@RequestMapping(value="/class/new", method=RequestMethod.POST)
    public String createClass(@RequestParam("class") String clase) {
		List<Student> user = new ArrayList<Student>();
		Class materia= new Class(clase, user);
        ClassServ.createClass(materia);
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
	@RequestMapping("/students/{id}")
	public String showStu(Model model, @PathVariable("id") Long id) {
		model.addAttribute("clases", ClassServ.allClass());
        model.addAttribute("alumno", StudentServ.findStudent(id));
		return "/students/student.jsp";
	}
	@RequestMapping(value="/students/{id}", method=RequestMethod.POST)
    public String addClass(@PathVariable("id") Long id, @RequestParam("clase") Long clas) {
		Class C = ClassServ.findClass(clas);
		Student stu = StudentServ.findStudent(id);
		stu.getClasses().add(C);		
		StudentServ.classStudent(stu);
		return "redirect:/";
    }
	@RequestMapping("/class/{id}")
	public String showClass(Model model, @PathVariable("id") Long id) {
        model.addAttribute("clase", ClassServ.findClass(id));
		return "/class/class.jsp";
	}
	@RequestMapping(value="/students/{id}", method=RequestMethod.DELETE)
    public String destroyStudent(@PathVariable("id") Long id) {
		Student user = StudentServ.findStudent(id);
		ContactServ.deleteContact(user.getContact().getId());
		StudentServ.deleteStudent(id);
		return "redirect:/students";
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
	@RequestMapping(value="/class/{id}", method=RequestMethod.DELETE)
    public String destroyClass(@PathVariable("id") Long id) {
		ClassServ.deleteClass(id);
		return "redirect:/";
    }
}
