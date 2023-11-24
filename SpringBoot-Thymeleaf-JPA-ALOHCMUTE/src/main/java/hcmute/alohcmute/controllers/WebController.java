package hcmute.alohcmute.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	@GetMapping("/")
	public String home() {
		return "web/dangky/dangky.html";
	}
}
