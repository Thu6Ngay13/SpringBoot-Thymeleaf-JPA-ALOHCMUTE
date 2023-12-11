package hcmute.alohcmute.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import hcmute.alohcmute.entities.BaiViet;
import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.repositories.BaiVietRepository;
import hcmute.alohcmute.repositories.TaiKhoanRepository;

@Service
public class BaiVietServiceImpl implements IBaiVietService{
	@Autowired
	BaiVietRepository baiVietRepository;
	
	@Autowired
	TaiKhoanRepository taiKhoanRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

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
	public long demSoTuongTac(int maBaiViet) {
		BaiViet baiViet = baiVietRepository.getById(maBaiViet);
		Set<TaiKhoan> listTaiKhoan = baiViet.getTaiKhoans();
		return listTaiKhoan.size();
	}

	@Override
	public long tangLike(int maBaiViet, String taiKhoan) {
		String sql = "INSERT INTO tuong_tac (tai_khoan, ma_bai_viet) values (?, ?)";
	    jdbcTemplate.update(sql, taiKhoan, maBaiViet);
		return demSoTuongTac(maBaiViet);
	}

	@Override
	public long giamLike(int maBaiViet, String taiKhoan) {
		String sql = "DELETE FROM tuong_tac WHERE tai_khoan = ? AND ma_bai_viet = ?";
	    jdbcTemplate.update(sql, taiKhoan, maBaiViet);
		return demSoTuongTac(maBaiViet);
	}

	@Override
	public boolean checkLiked(int maBaiViet, String taiKhoan) {
		BaiViet baiViet = baiVietRepository.getById(maBaiViet);
		if (baiViet.getTaiKhoans().contains(taiKhoanRepository.findOneBytaiKhoan(taiKhoan)))
			return true;
		return false;
	}
}
