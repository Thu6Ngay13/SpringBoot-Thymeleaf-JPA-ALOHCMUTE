package hcmute.alohcmute.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.alohcmute.entities.BaiViet;
import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.repositories.BaiVietRepository;

@Service
public class BaiVietServiceImpl implements IBaiVietService{
	@Autowired
	BaiVietRepository baiVietRepository;

	@Override
	public List<BaiViet> findAll() {
		return baiVietRepository.findAll();
	}

	@Override
	public Optional<BaiViet> findById(Integer id) {
		return baiVietRepository.findById(id);
	}

	@Override
	public BaiViet getById(Integer id) {
		return baiVietRepository.getById(id);
	}

	@Override
	public List<BaiViet> findAllBaiVietByUsername(String taiKhoanUsername) {
		return baiVietRepository.findAllBaiVietByUsername(taiKhoanUsername);
	}

	@Override
	public void deleteById(Integer id) {
		baiVietRepository.deleteById(id);
	}
	
	@Override
	public long demSoTuongTac(int maBaiViet) {
		BaiViet baiViet = baiVietRepository.getById(maBaiViet);
		Set<TaiKhoan> listTaiKhoan = baiViet.getTaiKhoans();
		return listTaiKhoan.size();
	}
}
