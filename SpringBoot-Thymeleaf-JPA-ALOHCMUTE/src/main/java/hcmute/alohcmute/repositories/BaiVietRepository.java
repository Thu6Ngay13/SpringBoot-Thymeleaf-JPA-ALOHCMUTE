package hcmute.alohcmute.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hcmute.alohcmute.entities.BaiViet;

@Repository
public interface BaiVietRepository extends JpaRepository<BaiViet, Integer> {

	
	@Query(value = "SELECT COUNT(*) FROM tuong_tac WHERE ma_bai_viet = :maBaiViet", nativeQuery = true)
    int countLikesByBaiVietId(@Param("maBaiViet") int maBaiViet);
	
	@Query(value = "SELECT COUNT(*) FROM binh_luan WHERE ma_bai_viet = :maBaiViet", nativeQuery = true)
    int countCommentsByBaiVietId(@Param("maBaiViet") int maBaiViet);
	
	@Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN CAST(1 AS BIT) ELSE CAST(0 AS BIT) END FROM tai_khoan_nhom tkn WHERE tkn.tai_khoan = :username AND tkn.ma_nhom = :maNhom", nativeQuery = true)
    boolean isUserInGroup(@Param("username") String username, @Param("maNhom") Integer maNhom);
}

