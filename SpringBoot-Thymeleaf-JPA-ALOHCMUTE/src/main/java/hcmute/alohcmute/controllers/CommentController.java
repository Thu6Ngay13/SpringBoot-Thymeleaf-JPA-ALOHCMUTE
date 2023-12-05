package hcmute.alohcmute.controllers;

import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hcmute.alohcmute.entities.BinhLuan;
import hcmute.alohcmute.services.BaiDangServiceImpl;
import hcmute.alohcmute.services.CommentSerrviceImpl;
import hcmute.alohcmute.services.IBaiDangService;
import hcmute.alohcmute.services.ICommentService;
import hcmute.alohcmute.services.ITaiKhoanService;
import hcmute.alohcmute.services.TaiKhoanServiceImpl;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class CommentController {
	@Autowired
	ICommentService commentService = new CommentSerrviceImpl();
	@Autowired
    IBaiDangService baiDangService = new BaiDangServiceImpl();
	@Autowired
    ITaiKhoanService taiKhoanService = new TaiKhoanServiceImpl();

	@GetMapping("/comment/{baiVietId}")
	public String reviewComment(ModelMap model, @PathVariable(value = "baiVietId") int id) {
		List<BinhLuan> comments = commentService.findCommentByMaBaiViet(id);
		model.addAttribute("comments", comments);
		model.addAttribute("baiVietId", id);
		BinhLuan binhLuan = new BinhLuan(); 
		model.addAttribute("binhLuan", binhLuan);
		return "user/comment/comment";
	}
	
	@PostMapping("/comment/{baiVietId}")
	public String addComment(@Valid BinhLuan binhLuan, BindingResult result, ModelMap model, @PathVariable(value = "baiVietId") int id) {
		if (result.hasErrors()) {
			return "user/comment/comment";
		}
		List<BinhLuan> comments = commentService.findCommentByMaBaiViet(id);
		model.addAttribute("comments", comments);
		if (binhLuan.getNoiDungChu() != "" && binhLuan.getNoiDungChu() != null) {
			binhLuan.setNgay(java.time.LocalDate.now());
			binhLuan.setThoiGian(java.time.LocalTime.now().truncatedTo(ChronoUnit.MINUTES));
			binhLuan.setBaiViet(baiDangService.getById(id));
			binhLuan.setTaiKhoan(taiKhoanService.findBytaiKhoan("thuycao816"));
			commentService.save(binhLuan);
		}
		return "redirect:{baiVietId}";
	}
	
	@GetMapping("/comment/{baiVietId}/delete/{commentId}")
	public String deleteComment(@PathVariable("commentId") int commentId, @PathVariable("baiVietId") int baiVietId, Model model) {
		commentService.deleteById(commentId);
        return "redirect:/user/comment/{baiVietId}";
    }
	
	@PostMapping("/comment/{baiVietId}/update")
	public String updateComment(@Valid BinhLuan binhLuan, BindingResult result, ModelMap model,  @PathVariable("baiVietId") int baiVietId) {
		BinhLuan binhLuanOld = commentService.getById(binhLuan.getMaBinhLuan());
		if (binhLuan.getNoiDungChu() != binhLuanOld.getNoiDungChu()) {
			binhLuanOld.setNoiDungChu(binhLuan.getNoiDungChu());
			binhLuanOld.setNgay(java.time.LocalDate.now());
			binhLuanOld.setThoiGian(java.time.LocalTime.now().truncatedTo(ChronoUnit.MINUTES));
			commentService.save(binhLuanOld);
		}
        return "redirect:/user/comment/{baiVietId}";
    }
}