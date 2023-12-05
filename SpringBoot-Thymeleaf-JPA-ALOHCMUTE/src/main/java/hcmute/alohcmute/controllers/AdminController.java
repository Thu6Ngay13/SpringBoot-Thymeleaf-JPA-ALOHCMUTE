package hcmute.alohcmute.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.models.TaiKhoanModel;
import hcmute.alohcmute.services.ITaiKhoanService;

@Controller
@RequestMapping("admin/manage")
public class AdminController {

	@Autowired
	ITaiKhoanService taiKhoanService;

	@GetMapping("quanlynguoidung")
	public String listTaiKhoan(ModelMap model) {

		List<TaiKhoan> list = taiKhoanService.findAll();
		model.addAttribute("listTaiKhoan", list);
		return "admin/manage/quanlynguoidung";
	}

	@GetMapping("/thongtintaikhoan/{taikhoan}")
	public String thongTinTaiKhoan(ModelMap model, @PathVariable("taikhoan") String taikhoan) {
		Optional<TaiKhoan> optTaiKhoan = taiKhoanService.findById(taikhoan);
		TaiKhoanModel taiKhoanModel = new TaiKhoanModel();
		// Kiem tra su ton tai
		if (optTaiKhoan.isPresent()) {
			TaiKhoan entity = optTaiKhoan.get();
			BeanUtils.copyProperties(entity, taiKhoanModel);

			model.addAttribute("taikhoan", taiKhoanModel);
			return "admin/manage/thongtintaikhoan";

		}
		model.addAttribute("message", "Error!!!");
		return "admin/manage/thongtintaikhoan";
	}

	@GetMapping("delete/{taikhoan}")
	public ModelAndView delete(ModelMap model, @PathVariable("taikhoan") String taikhoan) {
		taiKhoanService.deleteById(taikhoan);
		model.addAttribute("message", "Xoa thanh cong!");
		return new ModelAndView("forward:/admin/manage/quanlynguoidung", model);
	}
	
}
