package hcmute.alohcmute.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import hcmute.alohcmute.dtos.TinNhanDto;
import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.security.SecurityUtil;
import hcmute.alohcmute.services.ITaiKhoanService;

@Controller
public class TinNhanController {

	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	@Autowired 
	private ITaiKhoanService taiKhoanService;

	@GetMapping("/chat")
	public String getDanhSachChat(Model model) {
		TaiKhoan taiKhoan = SecurityUtil.getMyUser();
		model.addAttribute("taikhoan", taiKhoan);
		
		List<TaiKhoan> danhsachbanbes = 
				taiKhoanService.findTaiKhoanFollowersByUsername(taiKhoan.getTaiKhoan());
		List<TaiKhoan> taiKhoanBiTheoDois =
				taiKhoanService.findTaiKhoanTheoDoisByUsername(taiKhoan.getTaiKhoan());
		danhsachbanbes.retainAll(taiKhoanBiTheoDois);
		model.addAttribute("danhsachbanbes", danhsachbanbes);
		
		return "user/chat/danhsachchat";
	}
	
	@GetMapping("/chat/{username}")
	public String getCuocHoiThoai(
			@PathVariable(value="username") String username, 
			Model model) {
		TaiKhoan taiKhoan = SecurityUtil.getMyUser();
		model.addAttribute("taikhoan", taiKhoan);
		
		List<TaiKhoan> danhsachbanbes = 
				taiKhoanService.findTaiKhoanFollowersByUsername(taiKhoan.getTaiKhoan());
		List<TaiKhoan> taiKhoanBiTheoDois =
				taiKhoanService.findTaiKhoanTheoDoisByUsername(taiKhoan.getTaiKhoan());
		danhsachbanbes.retainAll(taiKhoanBiTheoDois);
		model.addAttribute("danhsachbanbes", danhsachbanbes);
        return "user/chat/cuochoithoai";
	}

	@MessageMapping("/chat.sendMessage")
	public void sendMessage(@Payload TinNhanDto tinNhanDto, @Header("topic") String topic) {

		messagingTemplate.convertAndSend("/chat/" + topic, tinNhanDto);
	}

}
