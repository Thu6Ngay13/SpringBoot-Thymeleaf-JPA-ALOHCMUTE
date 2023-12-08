package hcmute.alohcmute.controllers;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

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
		
		List<TaiKhoan> tkDuocTheoDoi = new ArrayList<>(tkSer.findTaiKhoanFollowersByUsername(username));
		model.addAttribute("ListTKDuocTheoDoi",tkDuocTheoDoi);
		
		Map<TaiKhoan, Integer> BanChung = tkSer.NguoiTheoDoiChung(username);
		model.addAttribute("BanChung",BanChung);
		
		return "user/banbe/banbe.html";
	}
	
	@GetMapping("unfollow")
	public ModelAndView delet(ModelMap model, @RequestParam("username") String userNameUnfollow) {

		String username="lolo928";
		TaiKhoan user1=tkSer.findBytaiKhoan(username);
		TaiKhoan user2=tkSer.findBytaiKhoan(userNameUnfollow);
		tkSer.unfollow(user1,user2);
		//tkSer.follow(user1, user2);


		return new ModelAndView("redirect:/user/follow", model);

	}
	
	@GetMapping("addfollow")
	public ModelAndView follow(ModelMap model, @RequestParam("username") String userNameFollow) {

		String username="lolo928";
		TaiKhoan user1=tkSer.findBytaiKhoan(username);
		TaiKhoan user2=tkSer.findBytaiKhoan(userNameFollow);
		tkSer.follow(user1,user2);


		return new ModelAndView("redirect:/user/follow", model);

	}
}
