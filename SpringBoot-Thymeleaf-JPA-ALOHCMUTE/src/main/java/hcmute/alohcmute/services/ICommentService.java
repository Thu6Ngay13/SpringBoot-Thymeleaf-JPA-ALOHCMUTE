package hcmute.alohcmute.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import hcmute.alohcmute.entities.BinhLuan;

public interface ICommentService {

	void deleteAll();

	BinhLuan getReferenceById(Integer id);

	void delete(BinhLuan entity);

	BinhLuan getById(Integer id);

	void deleteById(Integer id);

	long count();

	BinhLuan getOne(Integer id);

	<S extends BinhLuan> boolean exists(Example<S> example);

	boolean existsById(Integer id);

	Optional<BinhLuan> findById(Integer id);

	List<BinhLuan> findAll();

	Page<BinhLuan> findAll(Pageable pageable);

	Optional<BinhLuan> findOne(Specification<BinhLuan> spec);

	List<BinhLuan> findAll(Sort sort);

	<S extends BinhLuan> List<S> saveAll(Iterable<S> entities);

	<S extends BinhLuan> S save(S entity);

	List<BinhLuan> findCommentByMaBaiViet(int maBV);

	long countBinhLuanByMaBaiViet(int maBaiViet);
}
