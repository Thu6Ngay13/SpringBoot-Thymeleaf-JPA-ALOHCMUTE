package hcmute.alohcmute.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import hcmute.alohcmute.entities.BinhLuan;
import hcmute.alohcmute.services.CommentSerrviceImpl;
import hcmute.alohcmute.services.ICommentService;

@Controller
public class CommentController {
	@Autowired
	ICommentService commentService = new CommentSerrviceImpl();
	@GetMapping("/user")
	public String reviewComment(ModelMap model) {
		List<BinhLuan> comments = commentService.findCommentByMaBaiViet(1);
		model.addAttribute("comments", comments);
		return "user/comment/comment";
	}
}
