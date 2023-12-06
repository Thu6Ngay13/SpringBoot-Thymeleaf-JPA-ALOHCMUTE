package hcmute.alohcmute.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("/admin")
	public String adminPage(Model model) {
		model.addAttribute("mess", "Welcome to admin page");		
		return "admin/home";
	}
}
