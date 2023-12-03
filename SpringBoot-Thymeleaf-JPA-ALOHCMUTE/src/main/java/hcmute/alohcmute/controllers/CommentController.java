package hcmute.alohcmute.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommentController {
	
	@GetMapping("/")
	public String reviewComment(ModelMap model) {
		return "user/comment/comment";
	}
}
