package hcmute.alohcmute.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hcmute.alohcmute.entities.LoaiTaiKhoan;
import hcmute.alohcmute.entities.TaiKhoan;

@Repository
public interface LoaiTaiKhoanRepository extends JpaRepository<LoaiTaiKhoan, Integer>{
	@Query("SELECT u FROM TaiKhoan t WHERE t.taiKhoan = :taiKhoan")
	TaiKhoan getTaiKhoanByTaiKhoan(@Param("taiKhoan") String taiKhoan);
	
	Optional<TaiKhoan> findByEmail(String email);
	Optional<TaiKhoan> findByTaiKhoanOrEmail(String taikhoan, String email);
	Optional<TaiKhoan> findByTaiKhoan(String taikhoan);
	boolean existsByEmail(String email);
	boolean existsByTaiKhoan(String taikhoan);
	
}
