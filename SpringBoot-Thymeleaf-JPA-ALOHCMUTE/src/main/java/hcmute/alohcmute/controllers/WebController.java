package hcmute.alohcmute.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	@GetMapping("/")
	public String home() {
<<<<<<< HEAD
		return "user/dangbai/dangbai.html";
=======
		return "user/banbe/banbe.html";
>>>>>>> Thuy
	}
	
}
