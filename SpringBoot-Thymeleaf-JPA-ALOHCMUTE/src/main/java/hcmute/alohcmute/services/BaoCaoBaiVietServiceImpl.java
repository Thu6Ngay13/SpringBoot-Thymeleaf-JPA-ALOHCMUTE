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

	@Override
	public <S extends BaoCaoBaiViet> S save(S entity) {
		return baoCaoBaiVietRepository.save(entity);
	}

	@Override
	public List<BaoCaoBaiViet> findAll() {
		return baoCaoBaiVietRepository.findAll();
	}

	@Override
	public <S extends BaoCaoBaiViet> Page<S> findAll(Example<S> example, Pageable pageable) {
		return baoCaoBaiVietRepository.findAll(example, pageable);
	}

	@Override
	public Optional<BaoCaoBaiViet> findById(Integer id) {
		return baoCaoBaiVietRepository.findById(id);
	}

	@Override
	public long count() {
		return baoCaoBaiVietRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		baoCaoBaiVietRepository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		baoCaoBaiVietRepository.deleteAll();
	}
	
	
}
