package hcmute.alohcmute.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import hcmute.alohcmute.entities.BaoCaoBaiViet;
import hcmute.alohcmute.repositories.BaoCaoBaiVietRepository;

@Service
public class BaoCaoBaiVietServiceImpl implements IBaoCaoBaiVietService{

	@Autowired
	BaoCaoBaiVietRepository baoCaoBaiVietRepository;

	public <S extends BaoCaoBaiViet> S save(S entity) {
		return baoCaoBaiVietRepository.save(entity);
	}

	public List<BaoCaoBaiViet> findAll() {
		return baoCaoBaiVietRepository.findAll();
	}

	public <S extends BaoCaoBaiViet> Page<S> findAll(Example<S> example, Pageable pageable) {
		return baoCaoBaiVietRepository.findAll(example, pageable);
	}

	public Optional<BaoCaoBaiViet> findById(Integer id) {
		return baoCaoBaiVietRepository.findById(id);
	}

	public long count() {
		return baoCaoBaiVietRepository.count();
	}

	public void deleteById(Integer id) {
		baoCaoBaiVietRepository.deleteById(id);
	}

	public void deleteAll() {
		baoCaoBaiVietRepository.deleteAll();
	}
	
	
}
