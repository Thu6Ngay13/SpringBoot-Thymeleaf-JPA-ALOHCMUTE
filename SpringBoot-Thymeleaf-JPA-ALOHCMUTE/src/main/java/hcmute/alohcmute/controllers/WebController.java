package hcmute.alohcmute.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class WebController {
	@GetMapping("/")
	public String home() {
		return "web/dangnhap/dangnhap.html";
	}
}
