package hcmute.alohcmute.services;

import java.util.List;
import java.util.Optional;

import hcmute.alohcmute.entities.BaiViet;
import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.entities.ThongBao;

public interface IThongBaoService {

	List<ThongBao>findAll();
	List<ThongBao> findByTaiKhoan(TaiKhoan taiKhoan);
	<S extends ThongBao> S save(S entity);

	/*
	 * List<ThongBao> findByTaiKhoan(String id);
	 */	/*
	 * List<ThongBao> findBymaTaiKhoanContaining(String id); Optional<ThongBao>
	 * findBymaTaiKhoan(String id);
	 */
}
