package hcmute.alohcmute.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public String hienThiNewFeed(ModelMap model, Principal principal) {
		/* String currentUsername = principal.getName(); */
		List<BaiViet> bv = iNewFeed.findPublicOrFollowedPosts("lolo928");
		Map<Integer, Boolean> likedPosts = new HashMap<>();
		Map<Integer, Integer> postLikesCount = new HashMap<>();
		Map<Integer, Integer> postCommentsCount = new HashMap<>();
		

		for (BaiViet post : bv) {
			likedPosts.put(post.getMaBaiViet(), iNewFeed.checkIfLiked(post.getMaBaiViet(), "lolo928"));
			postLikesCount.put(post.getMaBaiViet(), iNewFeed.getLikeCount(post.getMaBaiViet()));
			postCommentsCount.put(post.getMaBaiViet(), iNewFeed.getCommentCount(post.getMaBaiViet()));
		}

		model.addAttribute("baiViets", bv);
		model.addAttribute("likedPosts", likedPosts);
		model.addAttribute("postLikesCount", postLikesCount);
		model.addAttribute("postCommentsCount", postCommentsCount);

		return "user/newfeed/newfeed";
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

	@PostMapping("/likePost")
	@ResponseBody
	public String likePost(@RequestParam("postId") int postId, Principal principal) {
		// Lấy username từ principal
		/* String username = principal.getName(); */
		System.out.println(postId);
		// Gọi service để cập nhật trạng thái like
		boolean isLiked = iNewFeed.toggleLike(postId, "lolo928");

		// Trả về kết quả dưới dạng String hoặc JSON
		return "{\"isLiked\": " + isLiked + "}";
	}

}
