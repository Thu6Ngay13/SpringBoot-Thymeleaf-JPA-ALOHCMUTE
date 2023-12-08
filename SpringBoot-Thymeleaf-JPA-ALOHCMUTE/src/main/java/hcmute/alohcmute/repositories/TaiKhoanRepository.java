package hcmute.alohcmute.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hcmute.alohcmute.entities.TaiKhoan;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, String> {
	@Query("SELECT t.taiKhoanTheoDois FROM TaiKhoan t WHERE t.taiKhoan = :taiKhoanUsername")
    List<TaiKhoan> findTaiKhoanTheoDoisByUsername(String taiKhoanUsername);
	
	@Query("SELECT t FROM TaiKhoan t JOIN t.taiKhoanTheoDois u WHERE u.taiKhoan = :taiKhoanUsername")
	List<TaiKhoan> findTaiKhoanFollowersByUsername(String taiKhoanUsername);
	
	TaiKhoan findOneBytaiKhoan(String username);
	
	@Query("SELECT t FROM TaiKhoan t JOIN t.taiKhoanTheoDois u WHERE u.taiKhoan = :taiKhoanUsername ORDER BY t.id DESC LIMIT 6")
	List<TaiKhoan> findTop5TaiKhoanFollowersByUsername(String taiKhoanUsername);
	
	@Query("SELECT count(t) FROM TaiKhoan t JOIN t.taiKhoanTheoDois u WHERE u.taiKhoan = :taiKhoanUsername")
	int countTaiKhoanFollowersByUsername(String taiKhoanUsername);
	
	@Query("SELECT t.taiKhoanTheoDois FROM TaiKhoan t WHERE t.taiKhoan = :taiKhoanUsername ORDER BY t.id DESC LIMIT 5")
    List<TaiKhoan> findTop5TaiKhoanTheoDoisByUsername(String taiKhoanUsername);
}
