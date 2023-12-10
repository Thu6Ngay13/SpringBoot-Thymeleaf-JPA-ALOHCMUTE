package hcmute.alohcmute.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import groovyjarjarasm.asm.util.Printer;
import hcmute.alohcmute.entities.BaiViet;
import hcmute.alohcmute.entities.BinhLuan;
import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.models.BaiVietModel;
import hcmute.alohcmute.models.TaiKhoanModel;
import hcmute.alohcmute.services.IBaiVietService;
import hcmute.alohcmute.services.ICommentService;
import hcmute.alohcmute.services.ITaiKhoanService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("trangcanhan")
public class TrangCaNhanController {

	@Autowired
	ITaiKhoanService taiKhoanService;

	@Autowired
	IBaiVietService baiVietService;

	@Autowired
	ICommentService commentService;

	@GetMapping("thongtintaikhoan/{taikhoan}") 
	public String thongTinTaiKhoan(ModelMap model, @PathVariable("taikhoan") String taikhoan,
			@RequestParam(name = "pageNoFriends", defaultValue = "1") Integer pageNoFriends,
			@RequestParam(name = "pageNoTimeline", defaultValue = "1") Integer pageNoTimeline,
			@RequestParam(name = "tab", defaultValue = "timeline") String tab) {
		Optional<TaiKhoan> optTaiKhoan = taiKhoanService.findById(taikhoan);
		TaiKhoanModel taiKhoanModel = new TaiKhoanModel();

		// danh sach tai khoan theo doi
		//List<TaiKhoan> taiKhoanTheoDoi = new ArrayList<>(taiKhoanService.findTaiKhoanFollowersByUsername(taikhoan));
		//model.addAttribute("taikhoantheodoi", taiKhoanTheoDoi);
		Page<TaiKhoan> taiKhoanTheoDoi = taiKhoanService.getTaiKhoanTheoDoiByPage(taikhoan, pageNoFriends - 1, 8);
		model.addAttribute("totalPageFriends", taiKhoanTheoDoi.getTotalPages());
		model.addAttribute("currentPageFriends", pageNoFriends);
		model.addAttribute("taikhoantheodoi", taiKhoanTheoDoi);

		// danh sach dang tai khoan theo doi
		List<TaiKhoan> taiKhoanDangTheoDoi = new ArrayList<>(taiKhoanService.findTaiKhoanTheoDoisByUsername(taikhoan));
		model.addAttribute("taikhoandangtheodoi", taiKhoanDangTheoDoi);

		List<TaiKhoan> top5TaiKhoanDuocTheoDoi = new ArrayList<>(
				taiKhoanService.findTop5TaiKhoanFollowersByUsername(taikhoan));
		model.addAttribute("top5taikhoanduoctheodoi", top5TaiKhoanDuocTheoDoi);

		// tong so tai khoan theo doi
		int countTaiKhoanDuocTheoDoi = taiKhoanService.countTaiKhoanFollowersByUsername(taikhoan);
		model.addAttribute("sotaikhoantheodoi", countTaiKhoanDuocTheoDoi);

		// danh sach tai khoan dang theo doi
		List<TaiKhoan> top5TaiKhoanDangTheoDoi = new ArrayList<>(
				taiKhoanService.findTop5TaiKhoanTheoDoisByUsername(taikhoan));
		model.addAttribute("top5taikhoandangtheodoi", top5TaiKhoanDangTheoDoi);

		// tong so tai khoan dang theo doi
		model.addAttribute("sotaikhoandangtheodoi", taiKhoanService.findTaiKhoanTheoDoisByUsername(taikhoan).size());

		// danh sach bai viet cua user
		//List<BaiViet> listBaiViet = baiVietService.findAllBaiVietByUsername(taikhoan);
		List<BaiVietModel> listBaiVietModel = new ArrayList<BaiVietModel>();
		//TEST
		Page<BaiViet> listBaiViet = baiVietService.getBaiVietByPage(taikhoan, pageNoTimeline - 1, 3);
		model.addAttribute("totalPageTimeline", listBaiViet.getTotalPages());
		model.addAttribute("currentPageTimeline", pageNoTimeline);
		model.addAttribute("listbaiviet", listBaiViet);

		for (BaiViet baiViet : listBaiViet) {
			long soComment = commentService.countBinhLuanByMaBaiViet(baiViet.getMaBaiViet());
			long soTuongTac = baiVietService.demSoTuongTac(baiViet.getMaBaiViet());
			BaiVietModel baiVietModel = new BaiVietModel();
			BeanUtils.copyProperties(baiViet, baiVietModel);
			baiVietModel.setSoComment(soComment);
			baiVietModel.setSoTuongTac(soTuongTac);
			listBaiVietModel.add(baiVietModel);
		}

		model.addAttribute("baivietmodel", listBaiVietModel);

		// thong tin tai khoan cua 1 user
		if (optTaiKhoan.isPresent()) {
			TaiKhoan entity = optTaiKhoan.get();
			BeanUtils.copyProperties(entity, taiKhoanModel);

			model.addAttribute("taikhoan", taiKhoanModel);
			
			if(tab.equals("timeline")) {
				model.addAttribute("tab", "timeline");
			}else if(tab.equals("about")) {
				model.addAttribute("tab", "about");
			}else if(tab.equals("photos")) {
				model.addAttribute("tab", "photos");
			} else if(tab.equals("friends")) {
				model.addAttribute("tab", "friends");
			}
				

			if (taikhoan.equals("user1")) {
				return "user/trangcanhan/trangcanhan";
			} else {
				List<TaiKhoan> list = new ArrayList<>(taiKhoanService.findTaiKhoanTheoDoisByUsername("user1"));
				if (list.contains(entity)) {
					model.addAttribute("follows", true);
				} else {
					model.addAttribute("follows", false);
				}
				return "user/trangcanhan/trangcanhan2";
			}

		}
		model.addAttribute("message", "Error!!");
		return "";
	}

	/*
	 * @GetMapping("taiKhoanTheoDoiByPage/{taikhoan}") public String
	 * taiKhoanTheoDoiByPage(ModelMap model, @PathVariable("taikhoan") String
	 * taikhoan,
	 * 
	 * @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
	 * Page<TaiKhoan> list = taiKhoanService.getTaiKhoanTheoDoiByPage(taikhoan,
	 * pageNo - 1, 2);
	 * 
	 * model.addAttribute("totalPage", list.getTotalPages());
	 * model.addAttribute("currentPage", pageNo); model.addAttribute("list", list);
	 * return "user/trangcanhan/trangcanhan"; }
	 */

	@PostMapping("update/{user}")
	public ModelAndView saveOrUpdate(ModelMap model, @PathVariable("user") String taikhoan,
			@Valid @ModelAttribute("taikhoan") TaiKhoanModel taiKhoanModel, BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("user/trangcanhan/trangcanhan");
		}

		Optional<TaiKhoan> optTaiKhoan = taiKhoanService.findById(taikhoan);
		TaiKhoan tk = optTaiKhoan.get();
		tk.setHoTen(taiKhoanModel.getHoTen());
		tk.setGioiTinh(taiKhoanModel.getGioiTinh());
		tk.setEmail(taiKhoanModel.getEmail());
		tk.setsDT(taiKhoanModel.getSDT());

		taiKhoanService.save(tk);

		String url = "redirect:/trangcanhan/thongtintaikhoan/" + taikhoan+"?tab=about";
		return new ModelAndView(url);

	}

	@GetMapping("/deletebaiviet/{taikhoan}/{mabaiviet}")
	public ModelAndView delete(ModelMap model, @PathVariable("mabaiviet") int mabaiviet,
			@PathVariable("taikhoan") String taikhoan) {
		
		List<BinhLuan> listBinhLuan = commentService.findCommentByMaBaiViet(mabaiviet);
		if(!listBinhLuan.isEmpty()) {
			commentService.deleteAllBinhLuanByMaBaiViet(mabaiviet);
		}
		
		baiVietService.deleteById(mabaiviet);
		model.addAttribute("message", "Xoa thanh cong!");

		String url = "forward:/trangcanhan/thongtintaikhoan/" + taikhoan;
		return new ModelAndView(url, model);
	}

	@GetMapping("/deleteTaiKhoanTheoDoi/{taikhoanbitheodoi}/{taikhoantheodoi}")
	public ModelAndView deleteTaiKhoanTheoDoi(ModelMap model,
			@PathVariable("taikhoanbitheodoi") String taikhoanbitheodoi,
			@PathVariable("taikhoantheodoi") String taikhoantheodoi) {

		taiKhoanService.unfollow(taiKhoanService.findById(taikhoantheodoi).get(),
				taiKhoanService.findById(taikhoanbitheodoi).get());
		model.addAttribute("message", "Xoa thanh cong!");

		String url = "forward:/trangcanhan/thongtintaikhoan/" + taikhoanbitheodoi;
		return new ModelAndView(url, model);
	}

	@GetMapping("/theoDoiTaiKhoan/{taikhoanbitheodoi}/{taikhoantheodoi}")
	public ModelAndView theoDoiTaiKhoan(ModelMap model, @PathVariable("taikhoanbitheodoi") String taikhoanbitheodoi,
			@PathVariable("taikhoantheodoi") String taikhoantheodoi) {

		taiKhoanService.follow(taiKhoanService.findById(taikhoantheodoi).get(),
				taiKhoanService.findById(taikhoanbitheodoi).get());
		model.addAttribute("message", "Them thanh cong!");

		String url = "forward:/trangcanhan/thongtintaikhoan/" + taikhoanbitheodoi;
		return new ModelAndView(url, model);
	}

	@GetMapping("/deleteTaiKhoanDangTheoDoi/{taikhoanbitheodoi}/{taikhoantheodoi}")
	public ModelAndView deleteTaiKhoanDangTheoDoi(ModelMap model,
			@PathVariable("taikhoanbitheodoi") String taikhoanbitheodoi,

			@PathVariable("taikhoantheodoi") String taikhoantheodoi) {

		taiKhoanService.unfollow(taiKhoanService.findById(taikhoantheodoi).get(),
				taiKhoanService.findById(taikhoanbitheodoi).get());
		model.addAttribute("message", "Xoa thanh cong!");

		String url = "forward:/trangcanhan/thongtintaikhoan/" + taikhoantheodoi;
		return new ModelAndView(url, model);
	}

}
