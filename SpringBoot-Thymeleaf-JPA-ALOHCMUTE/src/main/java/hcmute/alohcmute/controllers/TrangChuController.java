package hcmute.alohcmute.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hcmute.alohcmute.services.BaiDangServiceImpl;
import hcmute.alohcmute.services.IBaiDangService;

@Controller
@RequestMapping("newfeed")
public class TrangChuController {
   
    @Autowired
    IBaiDangService baiDangService = new BaiDangServiceImpl();

    @GetMapping("")
    public String hienThiNewFeed(ModelMap model) {
//        model.addAttribute("baiViets", iBaiDangService.findAll());
        System.out.println(baiDangService.findAll().get(0));
        return "test"; // Tên file template Thymeleaf đúng dựa vào cấu trúc thư mục
    }
}