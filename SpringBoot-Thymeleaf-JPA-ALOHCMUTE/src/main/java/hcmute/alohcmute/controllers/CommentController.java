package hcmute.alohcmute.controllers;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

import hcmute.alohcmute.entities.BaiViet;
import hcmute.alohcmute.entities.BinhLuan;
import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.entities.ThongBao;
import hcmute.alohcmute.services.BaiVietServiceImpl;
import hcmute.alohcmute.services.CommentSerrviceImpl;
import hcmute.alohcmute.services.IBaiVietService;
import hcmute.alohcmute.services.ICommentService;
import hcmute.alohcmute.services.ITaiKhoanService;
import hcmute.alohcmute.services.IThongBaoService;
import hcmute.alohcmute.services.TaiKhoanServiceImpl;
import hcmute.alohcmute.services.ThongBaoServiceImpl;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class CommentController {
	@Autowired
	ICommentService commentService = new CommentSerrviceImpl();
	@Autowired
    IBaiVietService baiVietService = new BaiVietServiceImpl();
	@Autowired
    ITaiKhoanService taiKhoanService = new TaiKhoanServiceImpl();
	
	@Autowired
	IThongBaoService thongBaoService = new ThongBaoServiceImpl();
	
	String username = "thuycao816";

	@GetMapping("/comment/{baiVietId}")
	public String reviewComment(ModelMap model, @PathVariable(value = "baiVietId") int id) {
		List<BinhLuan> comments = commentService.findCommentByMaBaiViet(id);
		long soLuongBinhLuan = commentService.countBinhLuanByMaBaiViet(id);
		long demSoTuongTac = baiVietService.demSoTuongTac(id);
		BaiViet baiViet = baiVietService.getById(id);
		model.addAttribute("isLiked", baiVietService.checkLiked(id, username));
		model.addAttribute("soLuongBinhLuan", soLuongBinhLuan);
		model.addAttribute("soLike", demSoTuongTac);
		model.addAttribute("comments", comments);
		model.addAttribute("baiViet", baiViet);
		BinhLuan binhLuan = new BinhLuan(); 
		model.addAttribute("binhLuan", binhLuan);		
		List<TaiKhoan> aa = taiKhoanService.findTaiKhoanFollowersByUsername(username);
		List<String> kq = new ArrayList<>();
		for (TaiKhoan ds : aa) {
			kq.add(ds.getTaiKhoan());
		}
		model.addAttribute("listbanbe",kq);
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
			binhLuan.setBaiViet(baiVietService.getById(id));
			binhLuan.setTaiKhoan(taiKhoanService.findBytaiKhoan(username));
			
			TaiKhoan taikhoan=taiKhoanService.findBytaiKhoan(username);
			
			
			Pattern pattern = Pattern.compile("@\\w+");

	        // Create a matcher for the input string
	        Matcher matcher = pattern.matcher(binhLuan.getNoiDungChu());

	        // Find and print all occurrences
	        while (matcher.find()) {
	            String match = matcher.group();
	            ThongBao tb = new ThongBao();
	            tb.setNgay(java.time.LocalDate.now());
	            String NoiDung = taikhoan.getHoTen()+" đã nhắc đến bạn trong một bình";
	            tb.setNoiDung(NoiDung);
	            String user=match.substring(1);
	            tb.setTaiKhoan(taiKhoanService.findBytaiKhoan(user));
	            tb.setThoiGian(java.time.LocalTime.now());
	            thongBaoService.save(tb);
	        }

			
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