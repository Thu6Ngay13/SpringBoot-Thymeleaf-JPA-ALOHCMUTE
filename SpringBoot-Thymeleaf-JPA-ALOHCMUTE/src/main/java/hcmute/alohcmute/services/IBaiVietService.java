package hcmute.alohcmute.services;

import java.util.List;
import java.util.Optional;

import hcmute.alohcmute.entities.BaiViet;

public interface IBaiVietService {

	Optional<BaiViet> findById(Integer id);

	List<BaiViet> findAll();

	BaiViet getById(Integer id);
	
	long demSoTuongTac(int maBaiViet);
	
	long tangLike(int maBaiViet, String taiKhoan);
	
	long giamLike(int maBaiViet, String taiKhoan);
	
	boolean checkLiked(int maBaiViet, String taiKhoan);
}
