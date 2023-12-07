package hcmute.alohcmute.repositories;

import hcmute.alohcmute.entities.BaoCaoBaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaoCaoBaiVietRepository extends JpaRepository<BaoCaoBaiViet, Long> {

}
