package hcmute.alohcmute.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.services.ITaiKhoanService;

@Controller
@RequestMapping("user")
public class TheoDoiController {

	@Autowired(required = true)
	ITaiKhoanService tkSer;
	@GetMapping("")
	public String TheoDoi(ModelMap model) {
		Optional<TaiKhoan> tkFind = tkSer.findById((long)(1));
		TaiKhoan tk = new TaiKhoan();
		if (tkFind.isPresent())
			tk = tkFind.get();
		List<TaiKhoan> tkTheoDoi = new ArrayList<>(tk.getTaiKhoanTheoDois());
		/*
		 * if (tkTheoDoi.isEmpty()) System.out.println("emty"); else
		 * System.out.println("emty");
		 */
		tkTheoDoi = tkSer.findAll();
		model.addAttribute("Listtaikhoan",tkTheoDoi);
		return "user/banbe/banbe.html";
	}
}
