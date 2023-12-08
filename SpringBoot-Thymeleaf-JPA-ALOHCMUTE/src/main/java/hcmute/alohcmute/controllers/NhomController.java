package hcmute.alohcmute.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hcmute.alohcmute.entities.BaiViet;
import hcmute.alohcmute.entities.Nhom;
import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.services.INhomService;
import hcmute.alohcmute.services.ITaiKhoanService;

@Controller
@RequestMapping("user/group")
public class NhomController {

	@Autowired(required = true)
	ITaiKhoanService tkSer;
	@Autowired(required = true)
	INhomService NhomSer;
	@GetMapping("")
	public String NhomCuaBan(ModelMap model) {
		String username = "lolo928";
		TaiKhoan tk = tkSer.findBytaiKhoan(username);
		Set<Nhom> setnhom =tk.getNhom();
		List<Nhom> listnhom = new ArrayList<>(setnhom);
		model.addAttribute("listnhom",listnhom);
		return "user/nhomcuaban/nhomcuaban.html";
	}
	
	@GetMapping("viewgroup")
	public String TheoDoi(ModelMap model, @RequestParam("groupID") String groupID) {
		int groupid = Integer.parseInt(groupID);
		Nhom nhom = NhomSer.findBymaNhom(groupid);
		model.addAttribute("Nhom",nhom);
		List<BaiViet> listBaiViet = new ArrayList<>(nhom.getBaiViets());
		model.addAttribute("listBaiViet",listBaiViet);
		return "user/nhom/nhom.html";
		
	}
	@GetMapping("searchgroup")
	public String TimKiemNhom(ModelMap model, @RequestParam("groupName") String groupName) {
		List<Nhom> listnhomTimKiem = NhomSer.findByTenNhomContainingIgnoreCase(groupName);
		model.addAttribute("listnhomTimKiem",listnhomTimKiem);
		model.addAttribute("tenGroup",groupName);
		NhomCuaBan(model);
		return "user/nhomcuaban/nhomcuaban.html";
	}
	
}
