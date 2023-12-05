package hcmute.alohcmute.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import hcmute.alohcmute.entities.TaiKhoan;

public interface ITaiKhoanService{

	void deleteById(Long id);

	long count();

	boolean existsById(Long id);

	Optional<TaiKhoan> findById(Long id);

	List<TaiKhoan> findAll();

	<S extends TaiKhoan> S save(S entity);

	List<TaiKhoan> findTaiKhoanTheoDoisByUsername(String taiKhoanUsername);
	
	List<TaiKhoan> findTaiKhoanFollowersByUsername(String taiKhoanUsername);

	void unfollow(TaiKhoan taiKhoan, TaiKhoan taiKhoanTheoDoi);
	
	TaiKhoan findBytaiKhoan (String username);

	void follow(TaiKhoan taiKhoan, TaiKhoan taiKhoanTheoDoi);

	Map<TaiKhoan, Integer> NguoiTheoDoiChung(String username);
}
