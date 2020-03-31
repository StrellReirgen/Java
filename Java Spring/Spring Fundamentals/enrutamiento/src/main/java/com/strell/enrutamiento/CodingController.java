package com.strell.enrutamiento;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {
	@RequestMapping("")
    public String coding() {
            return "¡Hola Coding Dojo!";
    }
    @RequestMapping("/javascript")
    public String javascript() {
            return "¡javascript/jquery fue increíble!";
    }
    @RequestMapping("/java")
    public String java() {
            return "¡Java/Spring es mejor!";
    }
}
