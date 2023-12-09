package hcmute.alohcmute.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import hcmute.alohcmute.entities.BaiViet;
import hcmute.alohcmute.entities.Nhom;
import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.entities.TaiKhoan_Nhom;
import hcmute.alohcmute.services.ICheDoService;
import hcmute.alohcmute.services.INhomService;
import hcmute.alohcmute.services.ITaiKhoanService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user/group")
public class NhomController {

	@Autowired(required = true)
	ITaiKhoanService tkSer;
	@Autowired(required = true)
	INhomService NhomSer;
	@Autowired
	ICheDoService cheDoSer;

	String username = "tien888";
	@GetMapping("")
	public String NhomCuaBan(ModelMap model) {
		// TaiKhoan tk = tkSer.findBytaiKhoan(username);
		// Set<Nhom> setnhom =tk.getNhom();
		// List<Nhom> listnhom = new ArrayList<>(setnhom);
		Map<Nhom, Boolean> List_Nhom = new HashMap<>();
		List<TaiKhoan_Nhom> tkNhom = NhomSer.findNhomTaiKhoan(username);
		for (TaiKhoan_Nhom taiKhoan_Nhom : tkNhom) {
			Nhom nhom = NhomSer.findBymaNhom(taiKhoan_Nhom.getId().getMaNhom());
			List_Nhom.put(nhom, taiKhoan_Nhom.isAccept());
		}
		// model.addAttribute("listnhom",listnhom);
		model.addAttribute("List_Nhom", List_Nhom);
		return "user/nhomcuaban/nhomcuaban.html";
	}

	@GetMapping("viewgroup")
	public String TheoDoi(ModelMap model, @RequestParam("groupID") String groupID) {
		int groupid = Integer.parseInt(groupID);
		Nhom nhom = NhomSer.findBymaNhom(groupid);
		model.addAttribute("Nhom", nhom);
		model.addAttribute("username",username);
		List<BaiViet> listBaiViet = new ArrayList<>(nhom.getBaiViets());
		model.addAttribute("listBaiViet", listBaiViet);
		return "user/nhom/nhom.html";

	}

	@GetMapping("searchgroup")
	public String TimKiemNhom(ModelMap model, @RequestParam("groupName") String groupName) {
		List<Nhom> listnhomTimKiem = NhomSer.findByTenNhomContainingIgnoreCase(groupName);
		boolean empty=false;
		if (listnhomTimKiem.isEmpty())
			empty=true;
		Map<Nhom, Integer> List_Nhom_TimKiem = new HashMap<>();
		List<TaiKhoan_Nhom> tkNhom = NhomSer.findNhomTaiKhoan(username);
		for (Nhom nhom : listnhomTimKiem) {
			List_Nhom_TimKiem.put(nhom, 0);
		}
		for (TaiKhoan_Nhom taiKhoan_Nhom : tkNhom) {
			Nhom nhom = NhomSer.findBymaNhom(taiKhoan_Nhom.getId().getMaNhom());
			if (taiKhoan_Nhom.getId().getTaiKhoan().equals(username) && List_Nhom_TimKiem.containsKey(nhom))
				if (taiKhoan_Nhom.isAccept())
					List_Nhom_TimKiem.put(nhom, 2);
				else List_Nhom_TimKiem.put(nhom, 1);			
		}
		model.addAttribute("List_Nhom_TimKiem",List_Nhom_TimKiem);
		NhomCuaBan(model);
		model.addAttribute("tenGroup",groupName);
		model.addAttribute("empty",empty);
		for (Nhom lisNhom : listnhomTimKiem) {
			System.out.println(lisNhom.getTenNhom());
		}
		return "user/nhomcuaban/nhomcuaban.html";
	}

	@GetMapping("joingroup")
	public String VaoNhom(ModelMap model, @RequestParam("groupID") String groupID) {
		TaiKhoan tk = tkSer.findBytaiKhoan(username);
		int GrID = Integer.parseInt(groupID);
		Nhom nhom = NhomSer.findBymaNhom(GrID);
		NhomSer.sendRequestToGroup(tk, nhom);
		NhomCuaBan(model);
		return "user/nhomcuaban/nhomcuaban.html";
	}
	
	@GetMapping("outgroup")
	public String RoiNhom(ModelMap model, @RequestParam("groupID") String groupID) {
		int GrID = Integer.parseInt(groupID);
		NhomSer.leaveGroup(username, GrID);
		NhomCuaBan(model);
		return "user/nhomcuaban/nhomcuaban.html";
	}
	
	@GetMapping("editgroup")
	public String ChinhSuaNhom(ModelMap model, @RequestParam("groupID") String groupID) {
		int GrID = Integer.parseInt(groupID);
		Nhom nhom = NhomSer.findBymaNhom(GrID);
		if (!username.equals(nhom.getTaiKhoanTruongNhom().getTaiKhoan()))
			return "redirect:/user/group/errorPage";
		model.addAttribute("nhom",nhom);
		List<TaiKhoan_Nhom> tkNhom = NhomSer.findTaiKhoanByNhom(GrID);
		List<TaiKhoan> thanhvien = new ArrayList<>();
		List<TaiKhoan> yeucau = new ArrayList<>();
		TaiKhoan taikhoanTemp = new TaiKhoan();
		for (TaiKhoan_Nhom taikhoanNhom : tkNhom) {
			taikhoanTemp = tkSer.findBytaiKhoan(taikhoanNhom.getId().getTaiKhoan());
			if (taikhoanNhom.isAccept())
				thanhvien.add(taikhoanTemp);
			else yeucau.add(taikhoanTemp);
		}
		model.addAttribute("thanhvien",thanhvien);
		model.addAttribute("yeucau",yeucau);
		return "user/nhom/quantrinhom.html";
	}
	
	@GetMapping("removeMember")
	public String XoaThanhVien(ModelMap model, @RequestParam("groupID") String groupID, 
						@RequestParam("username") String usernameRemove, HttpServletRequest request){
		int grID= Integer.parseInt(groupID);
		String usernameConvert = usernameRemove.substring(1,usernameRemove.length()-1);
		NhomSer.leaveGroup(usernameConvert, grID);
		String referer = request.getHeader("referer");
        return "redirect:" + (referer != null ? referer : "/defaultPath");

	}
	
	@GetMapping("/errorPage")
    @ResponseBody
    public String errorPage() {
        return "<html><body><h1>Bạn không là nhóm trưởng không thể truy cập trang này</h1></body></html>";
    }

	@GetMapping("addMember")
	public String ThemThanhVien(ModelMap model, @RequestParam("groupID") String groupID, 
						@RequestParam("username") String usernameAdd, HttpServletRequest request){
		int grID= Integer.parseInt(groupID);
		String usernameConvert = usernameAdd.substring(1,usernameAdd.length()-1);
		NhomSer.addMember(usernameConvert, grID);
		String referer = request.getHeader("referer");
        return "redirect:" + (referer != null ? referer : "/defaultPath");

	}
	
	@PostMapping("saveEdit")
	public String LuuThayDoi(ModelMap model, @RequestParam("groupName") String groupName, 
			@RequestParam("CheDo") String CheDo,@RequestParam("groupID") String groupID, HttpServletRequest request){
		int grID= Integer.parseInt(groupID);
		Nhom nhom = NhomSer.findBymaNhom(grID);
		int CheDoID;
		if (CheDo.equals("public"))
			CheDoID=1;
		else CheDoID=3;
		nhom.setCheDoNhom(cheDoSer.findByID(CheDoID).get());
		nhom.setTenNhom(groupName);
		NhomSer.Save(nhom);
//		String usernameConvert = usernameAdd.substring(1,usernameAdd.length()-1);
//		NhomSer.addMember(usernameConvert, grID);
		String referer = request.getHeader("referer");
		return "redirect:" + (referer != null ? referer : "/defaultPath");
	}
}
