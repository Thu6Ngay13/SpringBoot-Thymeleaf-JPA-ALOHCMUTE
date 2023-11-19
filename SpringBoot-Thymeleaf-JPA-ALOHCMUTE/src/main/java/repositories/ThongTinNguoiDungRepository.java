package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hcmute.alohcmute.entities.ThongTinNguoiDung;

@Repository
public interface ThongTinNguoiDungRepository extends JpaRepository<ThongTinNguoiDung, Integer>{

}	
