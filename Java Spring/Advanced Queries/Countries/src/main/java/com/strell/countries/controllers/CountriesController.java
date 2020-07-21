package com.strell.countries.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.strell.countries.models.Country;
import com.strell.countries.services.ApiService;

@Controller
public class CountriesController {
	private final ApiService ApiServ;
	public CountriesController(ApiService d){
        this.ApiServ = d;
    }
	@RequestMapping("/")
    public String index() {
		return "/index.jsp";
    }
	@RequestMapping("/1")
    public String index1(Model model) {
		List<Country> busqueda = ApiServ.primerConsulta();
		model.addAttribute("lista", busqueda);
		return "/1.jsp";
    }
	@RequestMapping("/2")
    public String index2(Model model) {
		List<Country> busqueda = ApiServ.segundaConsulta();
		model.addAttribute("lista", busqueda);
		return "/2.jsp";
    }
	@RequestMapping("/3")
    public String index3(Model model) {
		Country busqueda = ApiServ.terceraConsulta();
		model.addAttribute("lista", busqueda);
		return "/3.jsp";
    }
	@RequestMapping("/4")
    public String index4(Model model) {
		List<Country> busqueda = ApiServ.cuartaConsulta();
		model.addAttribute("lista", busqueda);
		return "/4.jsp";
    }
	@RequestMapping("/5")
    public String index5(Model model) {
		List<Country> busqueda = ApiServ.quintaConsulta();
		model.addAttribute("lista", busqueda);
		return "/5.jsp";
    }
	@RequestMapping("/6")
    public String index6(Model model) {
		List<Country> busqueda = ApiServ.sextaConsulta();
		model.addAttribute("lista", busqueda);
		return "/6.jsp";
    }
	@RequestMapping("/7")
    public String index7(Model model) {
		Country busqueda = ApiServ.septimaConsulta();
		model.addAttribute("lista", busqueda);
		return "/7.jsp";
    }
	@RequestMapping("/8")
    public String index8(Model model) {
		List<Object[]> busqueda = ApiServ.octavaConsulta();
		model.addAttribute("lista", busqueda);
		return "/8.jsp";
    }
}
