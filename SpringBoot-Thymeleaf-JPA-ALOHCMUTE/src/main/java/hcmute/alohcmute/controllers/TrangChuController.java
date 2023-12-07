package hcmute.alohcmute.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hcmute.alohcmute.entities.BaiViet;
import hcmute.alohcmute.services.IBaoCaoBaiVietService;
import hcmute.alohcmute.services.INewFeedService;

@Controller
@RequestMapping("user")
public class TrangChuController {

	@Autowired
	INewFeedService iNewFeed;

	@Autowired
	IBaoCaoBaiVietService baoCaoBaiVietService;

	@GetMapping("/newfeed")
	public String hienThiNewFeed(ModelMap model) {
		/* String currentUsername = principal.getName(); */// Get the username of the logged-in user
		/*
		 * List<BaiViet> bv = iNewFeed.findPublicOrFollowedPosts("thuycao816");
		 * System.out.println(bv.size());
		 */
		model.addAttribute("baiViets", iNewFeed.findPublicOrFollowedPosts("lolo928"));
		return "user/newfeed/newfeed.html";
	}

	@GetMapping("/reportPost")
	public String reportPost(RedirectAttributes redirectAttributes, @RequestParam("postId") int postId,
			@RequestParam("reason") String reason) {
		baoCaoBaiVietService.reportPost(postId, reason);

		// Thêm thông báo thành công vào redirect attributes nếu cần
		redirectAttributes.addFlashAttribute("reportSuccess", "Báo cáo đã được gửi thành công.");

		// Chuyển hướng người dùng trở lại trang newfeed
		return "redirect:newfeed";
	}

}
