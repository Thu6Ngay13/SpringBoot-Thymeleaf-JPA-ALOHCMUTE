package hcmute.alohcmute.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hcmute.alohcmute.entities.TaiKhoan;

@Repository
public interface ITaiKhoanRepository extends JpaRepository<TaiKhoan, Integer>{
	@Query("SELECT u FROM tai_khoan u WHERE u.taikhoan = :taikhoan")
	public TaiKhoan GetUserbyTaiKhoan(@Param("taikhoan") String taikhoan);
	
	
}
