package hcmute.alohcmute.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/")
	public String home() {
		return "web/dangnhap/dangnhap.html";
	}
}
