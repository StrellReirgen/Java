package com.strell.gold;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(HttpSession session) {
		Integer gold = (Integer) session.getAttribute("gold");
		Integer salud = (Integer) session.getAttribute("salud");
		if (gold == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("salud", 100);
			session.setAttribute("activities", new ArrayList<String>());
		}
		if ((Integer) session.getAttribute("salud") > 100) {
			session.setAttribute("salud", 100);
		}
		if ((Integer) session.getAttribute("salud") <= 0) {
			return "tumba.jsp";
		}else if ((Integer) session.getAttribute("gold") < -50) {
			return "carcel.jsp";
		} else {
			return "index.jsp";
		}
	}
	@RequestMapping(value="/farm", method=RequestMethod.POST)
	public String farm(HttpSession session) {
		String tiempo= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Random rand = new Random();
		Integer gold = (Integer) session.getAttribute("gold");
		Integer salud = (Integer) session.getAttribute("salud");
		Integer azar = rand.nextInt((21) - 10)+10;
		gold += azar;
		salud -= 10;
		session.setAttribute("salud", salud);
		session.setAttribute("gold", gold);
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		activities.add("Fuiste a trabajar a la Granja y ganaste "+ azar +" de Oro, y gastaste "+ 10 +" de salud. ("+ tiempo +")");
		return "redirect:/";
	}
	@RequestMapping(value="/cave", method=RequestMethod.POST)
	public String cave(HttpSession session) {
		String tiempo= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Random rand = new Random();
		Integer gold = (Integer) session.getAttribute("gold");
		Integer salud = (Integer) session.getAttribute("salud");
		Integer azar = rand.nextInt((11) - 5)+5;
		gold += azar;
		salud -= 5;
		session.setAttribute("salud", salud);
		session.setAttribute("gold", gold);
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		activities.add("Te aventuraste a una cueva y ganaste "+ azar +" de Oro, y gastaste "+ 5 +" de salud. ("+ tiempo +")");
		return "redirect:/";
	}
	@RequestMapping(value="/house", method=RequestMethod.POST)
	public String house(HttpSession session) {
		String tiempo= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Random rand = new Random();
		Integer gold = (Integer) session.getAttribute("gold");
		Integer salud = (Integer) session.getAttribute("salud");
		gold -= 2;
		Integer azar = rand.nextInt((6) - 2)+2;
		salud += azar;
		session.setAttribute("salud", salud);
		session.setAttribute("gold", gold);
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		activities.add("Decidiste quedarte en casa a descansar y perdiste "+ 2 +" de Oro, y recuperaste "+ azar +" de salud. ("+ tiempo +")");
		return "redirect:/";
	}
	@RequestMapping(value="/casino", method=RequestMethod.POST)
	public String casino(HttpSession session) {
		String tiempo= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Random rand = new Random();
		Integer gold = (Integer) session.getAttribute("gold");
		Integer salud = (Integer) session.getAttribute("salud");
		Integer suerte = rand.nextInt(11);
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		if (suerte < 2) {
			Integer azar = rand.nextInt(51);
			gold += azar;
			salud += 15;
			activities.add("Fuiste a jugar al Casino, que buena suerte ganaste "+ azar +" de Oro, y además recuperaste "+ 15 +" de salud. ("+ tiempo +")");
		} else {
			Integer azar = rand.nextInt(51);
			gold -= azar;
			salud += 15;
			activities.add("Fuiste a jugar al Casino, que mala suerte perdiste "+ azar +" de Oro, pero por lo menos recuperaste "+ 15 +" de salud. ("+ tiempo +")");
		}
		session.setAttribute("salud", salud);
		session.setAttribute("gold", gold);
		return "redirect:/";
	}
	@RequestMapping(value="/food", method=RequestMethod.POST)
	public String food(HttpSession session) {
		String tiempo= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Random rand = new Random();
		Integer gold = (Integer) session.getAttribute("gold");
		Integer salud = (Integer) session.getAttribute("salud");
		gold -= 5;
		Integer azar = rand.nextInt((11) - 5)+5;
		salud += azar;
		session.setAttribute("salud", salud);
		session.setAttribute("gold", gold);
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		activities.add("Fuiste a Comer algo afuera y perdiste "+ 5 +" de Oro, y recuperaste "+ azar +" de salud. ("+ tiempo +")");
		return "redirect:/";
	}
	@RequestMapping(value="/game", method=RequestMethod.POST)
	public String game(HttpSession session) {
		String tiempo= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Random rand = new Random();
		Integer gold = (Integer) session.getAttribute("gold");
		Integer salud = (Integer) session.getAttribute("salud");
		Integer azar = rand.nextInt((21) - 5)+5;
		gold -= azar;
		salud += 5;
		session.setAttribute("salud", salud);
		session.setAttribute("gold", gold);
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		activities.add("Fuiste a jugar a un Salon Arcade y perdiste "+ azar +" de Oro, y recuperaste "+ 5 +" de salud. ("+ tiempo +")");
		return "redirect:/";
	}
	@RequestMapping(value="/reset", method=RequestMethod.POST)
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
