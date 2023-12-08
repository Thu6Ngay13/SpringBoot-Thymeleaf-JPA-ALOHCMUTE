package hcmute.alohcmute.services;

import java.util.List;
import java.util.Optional;

import hcmute.alohcmute.entities.BaiViet;

public interface IBaiVietService {

	Optional<BaiViet> findById(Integer id);

	List<BaiViet> findAll();

	BaiViet getById(Integer id);

	List<BaiViet> findAllBaiVietByUsername(String taiKhoanUsername);

	void deleteById(Integer id);
	
	long demSoTuongTac(int maBaiViet);
}
