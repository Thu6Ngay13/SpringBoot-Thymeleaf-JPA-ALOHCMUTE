package hcmute.alohcmute.controllers;



import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import hcmute.alohcmute.entities.BaiViet;
import hcmute.alohcmute.entities.CheDo;
import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.entities.ThongBao;
import hcmute.alohcmute.services.IBaiVietService;
import hcmute.alohcmute.services.ICheDoService;
import hcmute.alohcmute.services.ITaiKhoanService;
import hcmute.alohcmute.services.IThongBaoService;
import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("user/dangbai")
public class DangBaiController{

	@Autowired
	IBaiVietService baivietSer;
	@Autowired
	ITaiKhoanService taikhoanSer;
	@Autowired
	ICheDoService chedoSer;
	@Autowired
	IThongBaoService tbSer;
	@Autowired
	ServletContext app;
	@RequestMapping("")
	public String list(ModelMap model)
	{
		TaiKhoan taikhoan=taikhoanSer.findBytaiKhoan("lolo928");
		model.addAttribute("taikhoan",taikhoan);

		return "user/dangbai/dangbai.html";
	}
	@PostMapping("add")
	public String add(ModelMap model,@RequestParam("noidungchu") String noidungchu,@RequestParam("privacy") String cdo,@RequestParam("file") MultipartFile noidunghinhanh)
	{
		String filename="";
		String uploadRootPath=app.getRealPath("upload");
		File uploadRootDir=new File(uploadRootPath);
		if(!uploadRootDir.exists())
		{
			uploadRootDir.mkdirs();
		}
		try {
			int extensionSTT=noidunghinhanh.getOriginalFilename().indexOf(".");
			String extension=noidunghinhanh.getOriginalFilename().substring(extensionSTT);
	        // Generate random integers in range 0 to 999
	        String stt = Integer.toString(LocalDateTime.now().getYear()) +Integer.toString(LocalDateTime.now().getDayOfYear())+Integer.toString(LocalDateTime.now().getHour())+Integer.toString(LocalDateTime.now().getMinute())+Integer.toString(LocalDateTime.now().getSecond());
			filename = stt+extension;
			
			File serverFile = new File(uploadRootDir.getAbsoluteFile() + File.separator + filename);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			stream.write(noidunghinhanh.getBytes());
			stream.close();

		} catch (Exception e) {	
		}
		BaiViet baiviet=new BaiViet();
		String tenchedo="";
		TaiKhoan taikhoan=taikhoanSer.findBytaiKhoan("lolo928");
		baiviet.setNoiDungChu(noidungchu);
		String linkanh= "/upload/"+filename;
		baiviet.setNoiDungHinhAnh(linkanh);
		baiviet.setTaiKhoan(taikhoan);
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
		Pattern pattern = Pattern.compile("@\\w+");

        // Create a matcher for the input string
        Matcher matcher = pattern.matcher(noidungchu);

        // Find and print all occurrences
        while (matcher.find()) {
            String match = matcher.group();
            ThongBao tb = new ThongBao();
            tb.setNgay(java.time.LocalDate.now());
            String NoiDung = taikhoan.getHoTen()+" đã nhắc đến bạn trong một bài viết";
            tb.setNoiDung(NoiDung);
            String user=match.substring(1);
            tb.setTaiKhoan(taikhoanSer.findBytaiKhoan(user));
            tb.setThoiGian(java.time.LocalTime.now());
            tbSer.save(tb);
        }
		System.out.println(tenchedo);
		CheDo chedo=chedoSer.findByCheDo(tenchedo);
		baiviet.setCheDoNhom(chedo);
		baiviet.setNgay(LocalDate.now());
		baiviet.setThoiGian(LocalTime.now());
		baivietSer.save(baiviet);


		return "user/newfeed/newfeed.html";
	}
	
}
