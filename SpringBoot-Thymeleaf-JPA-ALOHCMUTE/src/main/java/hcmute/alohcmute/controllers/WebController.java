package hcmute.alohcmute.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hcmute.alohcmute.dtos.TaiKhoanDto;
import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.events.RegistrationCompleteEvent;
import hcmute.alohcmute.services.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class WebController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private ApplicationEventPublisher publisher;

	// handler method to handle login request
	@GetMapping("/login")
	public String login() {
		return "web/dangnhap";
	}

	// handler method to handle user registration form request
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		// create model object to store form data
		TaiKhoanDto taiKhoanDto = new TaiKhoanDto();
		model.addAttribute("user", taiKhoanDto);
		return "web/dangky";
	}
	
	// handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(
    		@Valid @ModelAttribute("user") TaiKhoanDto taiKhoanDto,
    		BindingResult result,
    		ModelMap model,
    		HttpServletRequest request) {

        if (result.hasErrors()) {
            model.addAttribute("user", taiKhoanDto);
            return "/register";
        }

        TaiKhoan user = userService.saveTaiKhoan(taiKhoanDto);
        publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
        
        return "redirect:/register?success";
//        return "web/dangkythanhcong";
    }
    
    @GetMapping("/register/verify")
    public String verify(@RequestParam("token") String token) {
    	Optional<TaiKhoan> user = userService.findByToken(token);
    	if(user.isPresent()) {
    		userService.saveEnable(user.get());
    		return "web/dangnhap";
    	}
    	else {
    		return "web/403";
    	}
    }
    
	// handler method to handle login request
	@GetMapping("/403")
	public String error() {
		return "web/403";
	}
	
	public String applicationUrl(HttpServletRequest request) {
    	return "http://" + request.getServerName() + ":" + request.getServerPort()+request.getContextPath();
    }

}
