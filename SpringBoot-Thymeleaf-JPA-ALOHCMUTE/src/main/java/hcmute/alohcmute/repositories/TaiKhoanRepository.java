package hcmute.alohcmute.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hcmute.alohcmute.entities.TaiKhoan;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, String>{
	@Query("SELECT t "
			+ "FROM TaiKhoan t "
			+ "WHERE t.taiKhoan = :taiKhoan")
	Optional<TaiKhoan> findBytaiKhoan(@Param("taiKhoan") String taiKhoan);
	
	@Query("SELECT t "
			+ "FROM TaiKhoan t "
			+ "WHERE t.email = :email")
	Optional<TaiKhoan> findByEmail(String email);
	
	@Query("SELECT t "
			+ "FROM TaiKhoan t "
			+ "WHERE t.email = :email "
			+ "or t.taiKhoan = :taiKhoan")
	Optional<TaiKhoan> findByTaiKhoanOrEmail(String taiKhoan, String email);
	
	@Query("SELECT t "
			+ "FROM TaiKhoan t "
			+ "WHERE t.taiKhoan = :taiKhoan")
	Optional<TaiKhoan> findByTaiKhoan(String taiKhoan);
	
	@Query("SELECT t "
			+ "FROM TaiKhoan t "
			+ "WHERE t.token = :token")
	Optional<TaiKhoan> findByToken(String token);
	
	@Query("SELECT CASE "
			+ "WHEN COUNT(e) > 0 "
			+ "THEN true ELSE false END "
			+ "FROM TaiKhoan e "
			+ "WHERE e.email = :email")
	boolean existByEmail(String email);
	
	@Query("SELECT CASE "
			+ "WHEN COUNT(e) > 0 "
			+ "THEN true ELSE false END "
			+ "FROM TaiKhoan e "
			+ "WHERE e.taiKhoan = :taiKhoan")
	boolean existByTaiKhoan(String taiKhoan);
}
