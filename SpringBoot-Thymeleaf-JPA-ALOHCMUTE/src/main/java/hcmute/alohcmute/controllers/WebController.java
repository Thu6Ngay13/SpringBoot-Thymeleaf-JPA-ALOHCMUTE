package hcmute.alohcmute.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	@GetMapping("/")
	public String home() {
<<<<<<< Updated upstream
		return "user/trangcanhan/trangcanhan.html";
=======
		return "user/comment/comment.html";
>>>>>>> Stashed changes
	}
}
