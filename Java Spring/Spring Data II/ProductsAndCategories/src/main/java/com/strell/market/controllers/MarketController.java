package com.strell.market.controllers;

import java.util.ArrayList;
import java.util.List;

//import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.strell.market.models.Product;
import com.strell.market.models.Category;
import com.strell.market.services.ProductService;
import com.strell.market.services.CategoryService;

@Controller
public class MarketController {
	private final CategoryService CateServ;
	private final ProductService ProServ;
	public MarketController(CategoryService a, ProductService b){
        this.CateServ = a;
        this.ProServ = b;
    }
	@RequestMapping("/")
    public String index(Model model) {
		model.addAttribute("categories", CateServ.allCategory());
		model.addAttribute("products", ProServ.allProduct());
		return "index.jsp";
    }
	@RequestMapping("/products/new")
    public String newPro() {
        return "/products/newPro.jsp";
    }
	@RequestMapping(value="/products/new", method=RequestMethod.POST)
    public String createPro(@RequestParam("name") String nombre, @RequestParam("desc") String descripcion, @RequestParam("price") float precio, RedirectAttributes errors) {
		if (nombre.length() < 2) {
			errors.addFlashAttribute("errorsA", "El nombre debe tener minimo 2 letras.");
		}
		if (precio < 0) {
			errors.addFlashAttribute("errorsB", "No puede ser un valor Negativo.");
		}
		if (nombre.length() < 2 || precio < 0) {
			return "redirect:/products/new";
		} else {
			List<Category> categories = new ArrayList<Category>();
			Product lugar= new Product(nombre, descripcion, precio, categories);
			ProServ.createProduct(lugar);
			return "redirect:/";  
		}
    }
	@RequestMapping("/categories/new")
    public String newCate() {
        return "/category/newCate.jsp";
    }
	@RequestMapping(value="/categories/new", method=RequestMethod.POST)
    public String createCate(@RequestParam("name") String nombre, RedirectAttributes errors) {
		if (nombre.length() < 2) {
			errors.addFlashAttribute("errors", "El nombre debe tener minimo 2 letras.");
			return "redirect:/categories/new";
		} else {
			List<Product> products = new ArrayList<Product>();
			Category lugar= new Category(nombre,products);
			CateServ.createCategory(lugar);
			return "redirect:/";
		}
    }
	@RequestMapping("/products/{id}")
	public String showPro(Model model, @PathVariable("id") Long id) {
		Product pro = ProServ.findProduct(id);
		model.addAttribute("category", CateServ.allCategory());
        model.addAttribute("products", pro);
		return "/products/pro.jsp";
	}
	@RequestMapping("/categories/{id}")
	public String showCate(Model model, @PathVariable("id") Long id) {
		Category cate = CateServ.findCategory(id);
        model.addAttribute("products", ProServ.allProduct());
        model.addAttribute("category", cate);
		return "/category/cate.jsp";
	}
	@RequestMapping(value="/products/{id}", method=RequestMethod.DELETE)
	public String destroyPro(@PathVariable("id") Long id) {
		ProServ.deleteProduct(id);
		return "redirect:/";
	}
	@RequestMapping(value="/categories/{id}", method=RequestMethod.DELETE)
	public String destroyCate(@PathVariable("id") Long id) {
		CateServ.deleteCategory(id);
		return "redirect:/";
	}
	@RequestMapping(value="/products/{id}", method=RequestMethod.POST)
    public String updatePro(@PathVariable("id") Long id, @RequestParam("category") Long cate) {
		Category C = CateServ.findCategory(cate);
		Product pro = ProServ.findProduct(id);
		pro.getCategories().add(C);		
		ProServ.updateProduct(pro);
		return "redirect:/products/"+id;  
		
    }
	@RequestMapping(value="/categories/{id}", method=RequestMethod.POST)
    public String updateCate(@PathVariable("id") Long id, @RequestParam("product") Long pro) {
		Category cate = CateServ.findCategory(id);
		Product P = ProServ.findProduct(pro);
		cate.getProducts().add(P);
		CateServ.updateCategory(cate);
		return "redirect:/categories/"+id;
    }
}
