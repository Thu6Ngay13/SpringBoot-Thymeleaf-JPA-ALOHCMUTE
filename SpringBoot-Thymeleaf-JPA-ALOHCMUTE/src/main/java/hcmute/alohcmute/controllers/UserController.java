package hcmute.alohcmute.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/user")
	public String userPage(Model model) {
		model.addAttribute("mess", "Welcome to user page");	
		return "user/home";
	}
}
