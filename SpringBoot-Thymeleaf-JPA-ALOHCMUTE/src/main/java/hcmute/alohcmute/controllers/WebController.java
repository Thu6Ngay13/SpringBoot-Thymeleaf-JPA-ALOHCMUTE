package hcmute.alohcmute.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	@GetMapping("/user")
	public String home(ModelMap model) {
		return "user/search/search";
	}
}
