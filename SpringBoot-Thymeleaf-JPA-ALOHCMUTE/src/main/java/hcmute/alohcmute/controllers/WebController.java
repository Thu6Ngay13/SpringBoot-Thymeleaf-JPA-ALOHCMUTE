package hcmute.alohcmute.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hcmute.alohcmute.dtos.TaiKhoanDto;
import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.events.ForgotPasswordSendEmailEvent;
import hcmute.alohcmute.events.RegisterVerifySendEmailEvent;
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
	public String showLoginForm() {
		return "web/dangnhap/dangnhap";
	}

	// handler method to handle user registration form request
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		// create model object to store form data
		TaiKhoanDto taiKhoanDto = new TaiKhoanDto();
		model.addAttribute("user", taiKhoanDto);
		return "web/dangky/dangky";
	}
	
	// handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(
    		@Valid @ModelAttribute("user") TaiKhoanDto taiKhoanDto,
    		BindingResult result,
    		Model model,
    		HttpServletRequest request) {

        if (result.hasErrors()) {
            model.addAttribute("user", taiKhoanDto);
            return "redirect:/register";
        }

        TaiKhoan user = userService.saveTaiKhoan(taiKhoanDto);
        publisher.publishEvent(new RegisterVerifySendEmailEvent(user, applicationUrl(request)));
        
        return "web/dangky/dangkythanhcong";
    }
    
    @GetMapping("/register/verify")
    public String verifyRegistration(@RequestParam("token") String token) {
    	Optional<TaiKhoan> user = userService.findByToken(token);
    	if(user.isPresent()) {
    		userService.saveEnable(user.get());
    		return "web/dangky/xacthuc";
    	}

    	return "redirect:/404";
    }

    @GetMapping("/forgotpassword")
    public String showForgotPasswordForm(Model model) {
    	String email = "";
    	model.addAttribute("email", email);
    	return "web/quenmatkhau/quenmatkhau";
    }
    
    @PostMapping("/forgotpassword/find")
    public String forgotPassword(
    		@RequestParam("email") String email, 
    		Model model,
    		HttpServletRequest request) {
    	Optional<TaiKhoan> user = userService.findByTaiKhoanOrEmail(email, email);
        if (user.isPresent()) {
        	publisher.publishEvent(new ForgotPasswordSendEmailEvent(user.get(), applicationUrl(request)));
        	model.addAttribute("mess", "Vui lòng kiểm tra email để thay đổi mật khẩu");
		}
        else {
			model.addAttribute("mess", "Email không tồn tại"); 
		}
    	return "web/quenmatkhau/quenmatkhau";
    }
    
    @GetMapping(value = "/forgotpassword/reset")
    public String showResetPassword(@RequestParam("token") String token) {
    	Optional<TaiKhoan> user = userService.findByToken(token);
    	if(user.isPresent()) {
    		return "web/quenmatkhau/datlaimatkhau";
    	}
    	else {
			return "redirect:/404";
		}	
    }
    
    @PostMapping(value = "/forgotpassword/reset")
    public String resetPassword(
    		@RequestParam("token") String token,
    		@RequestParam("email") String email, 
    		Model model,
    		HttpServletRequest request) {
    	Optional<TaiKhoan> user = userService.findByToken(token);
    	if(user.isPresent()) {
        	if(user.isPresent()) {
        		userService.saveEnable(user.get());
        		model.addAttribute("mess", "Thay đổi mật khẩu thành công");
        		return "web/quenmatkhau/datlaimatkhau";
        	}
    	}

    	return "redirect:/404";
    }
    
	// handler method to handle login request
	@GetMapping("/403")
	public String error403() {
		return "web/error/403";
	}
	
	@GetMapping("/404")
	public String error404() {
		return "web/error/404";
	}
	
	public String applicationUrl(HttpServletRequest request) {
    	return "http://" + request.getServerName() + ":" + request.getServerPort()+request.getContextPath();
    }

}
;