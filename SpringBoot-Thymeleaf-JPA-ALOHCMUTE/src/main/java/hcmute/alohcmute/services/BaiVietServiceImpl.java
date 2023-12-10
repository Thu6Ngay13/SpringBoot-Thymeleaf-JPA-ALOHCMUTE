package hcmute.alohcmute.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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
	
	@Override
	public Page<BaiViet> getBaiVietByPage(String taikhoan, int page, int pageSize) {
		List<BaiViet> listBaiViet = findAllBaiVietByUsername(taikhoan);
		int fromIndex = page * pageSize;
        int toIndex = Math.min((page + 1) * pageSize, listBaiViet.size());

        if (fromIndex > toIndex) {
            // Trang yêu cầu không hợp lệ
            return new PageImpl<>(List.of()); // Trả về trang trống
        }

        List<BaiViet> baiVietOnPage = listBaiViet.subList(fromIndex, toIndex);
        return new PageImpl<>(baiVietOnPage, PageRequest.of(page, pageSize), listBaiViet.size());
    }
}
