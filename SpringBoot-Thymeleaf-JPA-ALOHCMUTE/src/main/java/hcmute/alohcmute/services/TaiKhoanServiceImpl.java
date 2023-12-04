package hcmute.alohcmute.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.repositories.TaiKhoanRepositories;

@Service
public class TaiKhoanServiceImpl implements ITaiKhoanService{
	
	@Autowired
	TaiKhoanRepositories taiKhoanRepository;

	public TaiKhoanServiceImpl(TaiKhoanRepositories taiKhoanRepository) {
		this.taiKhoanRepository = taiKhoanRepository;
	}

	@Override
	public <S extends TaiKhoan> S save(S entity) {
		return taiKhoanRepository.save(entity);
	}

	@Override
	public List<TaiKhoan> findAll() {
		return taiKhoanRepository.findAll();
	}

	@Override
	public Optional<TaiKhoan> findById(String id) {
		return taiKhoanRepository.findById(id);
	}

	@Override
	public long count() {
		return taiKhoanRepository.count();
	}

	@Override
	public void deleteById(String id) {
		taiKhoanRepository.deleteById(id);
	}
	
	
	
}
