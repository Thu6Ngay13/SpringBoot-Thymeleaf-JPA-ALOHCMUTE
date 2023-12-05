package hcmute.alohcmute.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.repositories.TaiKhoanRepository;

@Service
public class TaiKhoanServiceImpl implements ITaiKhoanService{
	@Autowired
	TaiKhoanRepository taiKhoanRepository;

	@Override
	public <S extends TaiKhoan> S save(S entity) {
		return taiKhoanRepository.save(entity);
	}

	@Override
	public Optional<TaiKhoan> findById(String id) {
		return taiKhoanRepository.findById(id);
	}
	
	
}
