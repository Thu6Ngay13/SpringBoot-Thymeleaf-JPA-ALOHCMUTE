package hcmute.alohcmute.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.entities.ThongBao;
import hcmute.alohcmute.services.ITaiKhoanService;
import hcmute.alohcmute.services.IThongBaoService;

@ControllerAdvice
public class ThongBaoController {

	@Autowired
	IThongBaoService thongbaoService;
	@Autowired
	ITaiKhoanService taiKhoanService;
	
	/*
	 * @GetMapping("TaiKhoan/taikhoan") public ResponseEntity<List<ThongBao>>
	 * getNotificationsByUserId(@PathVariable String taiKhoan) { List<ThongBao>
	 * notifications = thongbaoService.findByTaiKhoan(taiKhoan); return new
	 * ResponseEntity<>(notifications, HttpStatus.OK); }
	 */
	/*
	 * @GetMapping("nhom") public String list1(ModelMap model) { TaiKhoan
	 * taikhoan=taiKhoanService.findBytaiKhoan("lolo928"); List<ThongBao>
	 * list=thongbaoService.findByTaiKhoan(taikhoan);
	 * model.addAttribute("thongbaos",list); return "user/nhom/nhom.html"; }
	 * 
	 * @GetMapping("banbe") public String list3(ModelMap model) { TaiKhoan
	 * taikhoan=taiKhoanService.findBytaiKhoan("lolo928"); List<ThongBao>
	 * list=thongbaoService.findByTaiKhoan(taikhoan);
	 * model.addAttribute("thongbaos",list); return "user/banbe/banbe.html"; }
	 * 
	 * @RequestMapping("") public String list2(ModelMap model) { TaiKhoan
	 * taikhoan=taiKhoanService.findBytaiKhoan("lolo928"); List<ThongBao>
	 * list=thongbaoService.findByTaiKhoan(taikhoan);
	 * model.addAttribute("thongbaos",list); return "user/fragments/header.html"; }
	 * 
	 * @GetMapping("seeall") public String list(ModelMap model) { List<ThongBao>
	 * list=thongbaoService.findAll(); model.addAttribute("thongbaos",list); return
	 * "user/thongbao/thongbao.html"; }
	 */
	@ModelAttribute("thongbaos")
    public List<ThongBao> getThongBaos() {
        TaiKhoan taiKhoan = taiKhoanService.findBytaiKhoan("lolo928");
        return thongbaoService.findByTaiKhoan(taiKhoan);
    }
}

