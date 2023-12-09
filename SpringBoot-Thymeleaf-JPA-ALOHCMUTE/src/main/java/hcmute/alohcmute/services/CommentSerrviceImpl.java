package hcmute.alohcmute.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import hcmute.alohcmute.entities.BaiViet;
import hcmute.alohcmute.entities.BinhLuan;
import hcmute.alohcmute.repositories.CommentRepositories;

@Service
public class CommentSerrviceImpl implements ICommentService{

	@Autowired
	CommentRepositories commentRepository;

	@Override
	public <S extends BinhLuan> S save(S entity) {
		return commentRepository.save(entity);
	}

	@Override
	public <S extends BinhLuan> List<S> saveAll(Iterable<S> entities) {
		return commentRepository.saveAll(entities);
	}

	@Override
	public List<BinhLuan> findAll(Sort sort) {
		return commentRepository.findAll(sort);
	}

	@Override
	public Optional<BinhLuan> findOne(Specification<BinhLuan> spec) {
		return commentRepository.findOne(spec);
	}

	@Override
	public Page<BinhLuan> findAll(Pageable pageable) {
		return commentRepository.findAll(pageable);
	}

	@Override
	public List<BinhLuan> findAll() {
		return commentRepository.findAll();
	}

	@Override
	public Optional<BinhLuan> findById(Integer id) {
		return commentRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return commentRepository.existsById(id);
	}

	@Override
	public <S extends BinhLuan> boolean exists(Example<S> example) {
		return commentRepository.exists(example);
	}

	@Override
	public BinhLuan getOne(Integer id) {
		return commentRepository.getOne(id);
	}

	@Override
	public long count() {
		return commentRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		commentRepository.deleteById(id);
	}

	@Override
	public BinhLuan getById(Integer id) {
		return commentRepository.getById(id);
	}

	@Override
	public void delete(BinhLuan entity) {
		commentRepository.delete(entity);
	}

	@Override
	public BinhLuan getReferenceById(Integer id) {
		return commentRepository.getReferenceById(id);
	}

	@Override
	public void deleteAll() {
		commentRepository.deleteAll();
	}

	@Override
	public List<BinhLuan> findCommentByMaBaiViet(int maBV) {
		List<BinhLuan> listAll = findAll();
		List<BinhLuan> list = new ArrayList<>();
		for (BinhLuan binhLuan : listAll) {
			if (binhLuan.getBaiViet() != null && binhLuan.getBaiViet().getMaBaiViet() == maBV)
				list.add(binhLuan);
		}
		return list;
	}

	@Override
	public long countBinhLuanByMaBaiViet(int maBaiViet) {
		return commentRepository.countByBaiViet_MaBaiViet(maBaiViet);
	}	
	
}
