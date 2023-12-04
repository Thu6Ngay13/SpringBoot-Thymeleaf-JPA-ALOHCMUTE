package hcmute.alohcmute.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import hcmute.alohcmute.entities.BinhLuan;

@Repository
public interface CommentRepositories extends JpaRepositoryImplementation<BinhLuan, Integer>{

}
