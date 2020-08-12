package com.strell.water.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.strell.water.models.Pool;
import com.strell.water.models.Review;
import com.strell.water.models.User;
import com.strell.water.services.PoolService;
import com.strell.water.services.ReviewService;
import com.strell.water.services.UserService;
import com.strell.water.validator.UserValidator;

@Controller
public class WaterController {
	private UserService userService;
    private UserValidator userValidator;
    private PoolService poolServ;
    private ReviewService revServ;
    
    public WaterController(UserService userService, UserValidator userValidator,PoolService pool,ReviewService rev) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.poolServ = pool;
        this.revServ = rev;
    }
    @RequestMapping(value = {"/","/home"})
    public String home(Principal principal, Model model) {
    	if (principal==null) {
    		return "homePage.jsp";
    	} else {
    		String username = principal.getName();
            model.addAttribute("user", userService.findByUsername(username));
            return "homePage.jsp";
    	}
    }
    @PostMapping("/search")
    public String search(Principal principal,@RequestParam("location") String place,Model model) {
    	model.addAttribute("pools", poolServ.findPoolByAddress(place));
    	if (principal==null) {
    		return "searchPage.jsp";
    	} else {
    		String username = principal.getName();
            model.addAttribute("user", userService.findByUsername(username));
            return "searchPage.jsp";
    	}
    }
    @RequestMapping("/pools/{id}")
    public String show(@PathVariable("id") Long poolId,Principal principal,Model model) {
    	if (principal!=null) {
    		String username = principal.getName();
            model.addAttribute("user", userService.findByUsername(username));
    	}
        model.addAttribute("pool", poolServ.findPool(poolId));
        return "showPool.jsp";
    }
    @RequestMapping("/{id}/review")
    public String review(Principal principal,@PathVariable("id") Long poolId,Model model) {
    	String username = principal.getName();
        model.addAttribute("user", userService.findByUsername(username));
    	model.addAttribute("pool", poolServ.findPool(poolId));
        return "reviewPage.jsp";
    	
    }
    @PostMapping("/{id}/review")
    public String newReview(@PathVariable("id") Long poolId,Principal principal,@RequestParam("message") String mensaje,@RequestParam("rating") Double valor) {
    	User a = userService.findByUsername(principal.getName());
    	revServ.createRev(new Review(mensaje,valor,a,poolServ.findPool(poolId)));
		return "redirect:/pools/"+poolId;
    }
	@PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result,@RequestParam("role") Long rolid,Model model, HttpSession session) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
            return "redirect:/login";
        }
		if (rolid == 1) {
			userService.saveWithUserRole(user);
		} else {
			userService.saveUserWithAdminRole(user);
		}
		return "redirect:/login";
    }
	@RequestMapping("/login")
    public String login(@Valid @ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
       if(error != null) {
            model.addAttribute("errorMessage", "Credenciales Invalidas, Porfavor Intente de nuevo.");
       }
       if(logout != null) {
            model.addAttribute("logoutMessage", "Sesion cerrada exitosamente");
       }
       model.addAttribute("roles", userService.allRole());
        return "loginPage.jsp";
    }
    
    @RequestMapping("/host/dashboard")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("user", userService.findByUsername(username));
        return "adminPage.jsp";
    }
    @PostMapping("/host/newpool")
    public String nPool(Principal principal, @RequestParam("address") String direccion, @RequestParam("desc") String descripcion, @RequestParam("cost") Double costo, @RequestParam("size") String tamaño) {
        User a = userService.findByUsername(principal.getName());
    	poolServ.createPool(direccion, descripcion, costo, tamaño, a.getId());
		return "redirect:/host/dashboard";
    }
    @RequestMapping("/host/pool/{id}")
    public String editpage(@PathVariable("id") Long poolId,Principal principal,Model model) {
    	String username = principal.getName();
        model.addAttribute("user", userService.findByUsername(username));
        model.addAttribute("pool", poolServ.findPool(poolId));
        return "editPool.jsp";
    }
    @PostMapping("/host/pool/{id}")
    public String editPool(@Valid @ModelAttribute("pool") Pool pool, BindingResult result) {
    	if (result.hasErrors()) {
            return "redirect:/host/pool/"+ pool.getId();
        } else {
        	poolServ.editPool(pool);
        	return "redirect:/host/dashboard";
        }
    }
}
