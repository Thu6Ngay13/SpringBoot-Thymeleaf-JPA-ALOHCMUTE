package hcmute.alohcmute.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.services.ITaiKhoanService;

@Controller
public class UserController {
	@Autowired
	ITaiKhoanService taiKhoanService;
	
	@GetMapping(value = {"/admin/chitiet/banUser/{taikhoan}/{mabaocao}", "/admin/chitiet/unbanUser/{taikhoan}/{mabaocao}"})
	public String banUser(@PathVariable(value = "taikhoan") String taikhoan, @PathVariable(value = "mabaocao") int mabaocao) {
		Optional<TaiKhoan> Opttaikhoan = taiKhoanService.findById(taikhoan); 
		TaiKhoan userban = Opttaikhoan.get();
		if (userban.isEnable()== true) {
			userban.setEnable(false);
		}
		else {
			userban.setEnable(true);
		}
		taiKhoanService.save(userban);
		
		return "redirect:/admin/chitiet/{mabaocao}";
	}
	
	@GetMapping("/user")
	public String userPage(Model model) {
		model.addAttribute("mess", "Welcome to user page");	
		return "user/home";
	}
}
