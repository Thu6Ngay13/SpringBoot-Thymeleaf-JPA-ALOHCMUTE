package hcmute.alohcmute.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hcmute.alohcmute.entities.CheDo;
import java.util.List;



@Repository
public interface CheDoRepository extends JpaRepository<CheDo, Long> {
	CheDo findOneBytenCheDo(String tenchedo);
}
