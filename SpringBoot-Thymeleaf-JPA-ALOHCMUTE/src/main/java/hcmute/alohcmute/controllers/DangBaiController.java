package hcmute.alohcmute.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hcmute.alohcmute.entities.BaiViet;
import hcmute.alohcmute.entities.CheDo;
import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.services.IBaiVietService;
import hcmute.alohcmute.services.ICheDoService;
import hcmute.alohcmute.services.ITaiKhoanService;

@Controller
@RequestMapping("user/dangbai")
public class DangBaiController {

	@Autowired
	IBaiVietService baivietSer;
	@Autowired
	ITaiKhoanService taikhoanSer;
	@Autowired
	ICheDoService chedoSer;
	@RequestMapping("")
	public String list(ModelMap model)
	{
		TaiKhoan taikhoan=taikhoanSer.findBytaiKhoan("lolo928");
		model.addAttribute("taikhoan",taikhoan);

		return "user/dangbai/dangbai.html";
	}
	@PostMapping("add")
	public String add(ModelMap model,@RequestParam("noidungchu") String noidungchu,@RequestParam("privacy") String cdo)
	{
		BaiViet baiviet=new BaiViet();
		String tenchedo="";
		TaiKhoan taikhoan=taikhoanSer.findBytaiKhoan("lolo928");
		baiviet.setNoiDungChu(noidungchu);
		baiviet.setTaiKhoan(taikhoan);
		//model.addAttribute("taikhoan",taikhoan);
		System.out.println(taikhoan.getHoTen());
		System.out.println(cdo);
		if(cdo.equals("Public"))
		{
			tenchedo="Công Khai";
		}
		else if(cdo.equals("Follower"))
		{
			tenchedo="Người Theo Dõi";
		}
		else if(cdo.equals("Private"))
		{
			tenchedo="Riêng Tư";
		}
		
		System.out.println(tenchedo);
		CheDo chedo=chedoSer.findByCheDo(tenchedo);
		baiviet.setCheDoNhom(chedo);
		baivietSer.save(baiviet);
		return "user/newfeed/newfeed.html";
	}
	
}
