package hcmute.alohcmute.controllers;

import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hcmute.alohcmute.entities.BinhLuan;
import hcmute.alohcmute.services.CommentSerrviceImpl;
import hcmute.alohcmute.services.ICommentService;

@Controller
@RequestMapping("user")
public class CommentController {
	@Autowired
	ICommentService commentService = new CommentSerrviceImpl();
	@GetMapping("/comment/{baiVietId}")
	public String reviewComment(ModelMap model, @PathVariable(value="baiVietId") int id) {
		List<BinhLuan> comments = commentService.findCommentByMaBaiViet(id);
		model.addAttribute("comments", comments);
		return "user/comment/comment";
	}
}
