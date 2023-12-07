package hcmute.alohcmute.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hcmute.alohcmute.entities.TaiKhoan;


public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Long>{
	@Query("SELECT t.taiKhoanTheoDois FROM TaiKhoan t WHERE t.taiKhoan = :taiKhoanUsername")
    List<TaiKhoan> findTaiKhoanTheoDoisByUsername(String taiKhoanUsername);
	
	@Query("SELECT t FROM TaiKhoan t JOIN t.taiKhoanTheoDois u WHERE u.taiKhoan = :taiKhoanUsername")
    List<TaiKhoan> findTaiKhoanFollowersByUsername(String taiKhoanUsername);
	
	TaiKhoan findOneBytaiKhoan(String username);
	
	
}
