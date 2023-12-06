package hcmute.alohcmute.services;

import java.util.List;
import java.util.Optional;

import hcmute.alohcmute.dtos.TaiKhoanDto;
import hcmute.alohcmute.entities.TaiKhoan;

public interface IUserService {

	List<TaiKhoan> getTaiKhoans();
	
	Optional<TaiKhoan> findByTaiKhoanOrEmail(String taiKhoan, String email);
	
	Optional<TaiKhoan> findByToken(String token);

	TaiKhoan saveTaiKhoan(TaiKhoanDto taiKhoanDto);

	void saveTaiKhoanVerificationToken(TaiKhoan user, String verificationToken);

	void saveEnable(TaiKhoan user);
}