package hcmute.alohcmute.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.entities.ThongBao;

@Repository
public interface ThongBaoRepository extends JpaRepository<ThongBao, String>  {

	
	/*
	 * List<ThongBao> findByTaiKhoan(String id);
	 *//*	 *	 Optional<ThongBao> findByTaiKhoan(String id);
*/	 
	List<ThongBao> findByTaiKhoan(TaiKhoan taiKhoan);
	 
	//Tìm kiếm và Phân trang
	/*
	 * Page<ThongBao> findByNameThongBaoContaining(String name,Pageable pageable);
	 * Optional<ThongBao> findByNameThongBao(String name);
	 */
}
