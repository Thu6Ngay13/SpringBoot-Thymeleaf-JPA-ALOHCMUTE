package hcmute.alohcmute.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hcmute.alohcmute.services.IUserService;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/user")
	public String userPage(Model model) {
		model.addAttribute("mess", "Welcome user page");
		model.addAttribute("users", userService.getTaiKhoans());
		return "user/home";
	}
}
