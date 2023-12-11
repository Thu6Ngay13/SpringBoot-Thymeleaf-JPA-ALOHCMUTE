package hcmute.alohcmute.services;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.alohcmute.entities.BaiViet;
import hcmute.alohcmute.entities.Nhom;
import hcmute.alohcmute.entities.ThongBao;
import hcmute.alohcmute.repositories.BaiVietRepository;

@Service
public class BaiVietServiceImpl implements IBaiVietService {

	@Autowired
	BaiVietRepository baivietrepo;
	
	@Autowired
	IThongBaoService iTB;
	
	@Autowired
	ITaiKhoanService taikhoanSer;
	
	
	@Override
	public <S extends BaiViet> S save(S entity) {
		baivietrepo.save(entity);
		Pattern pattern = Pattern.compile("@\\w+");

        // Create a matcher for the input string
        Matcher matcher = pattern.matcher(entity.getNoiDungChu());

       
        // Find and print all occurrences
        while (matcher.find()) {
            String match = matcher.group();
            ThongBao tb = new ThongBao();
            tb.setNgay(java.time.LocalDate.now());
            String NoiDung = entity.getTaiKhoan().getHoTen()+" đã nhắc đến bạn trong một bài viết";
            tb.setNoiDung(NoiDung);
            String user=match.substring(1);
            tb.setTaiKhoan(taikhoanSer.findBytaiKhoan(user));
            tb.setThoiGian(java.time.LocalTime.now());
            tb.setLinkThongBao("/user/comment/" + entity.getMaBaiViet());
            iTB.save(tb);
        }
        return entity;
	}

	@Override
	public List<BaiViet> findBymaNhom(Nhom Nhom){
		return baivietrepo.findBynhom(Nhom);
		
	}

	@Override
	public BaiViet findBymaBaiViet(int mabv) {
		return baivietrepo.findBymaBaiViet(mabv);
	}
}
