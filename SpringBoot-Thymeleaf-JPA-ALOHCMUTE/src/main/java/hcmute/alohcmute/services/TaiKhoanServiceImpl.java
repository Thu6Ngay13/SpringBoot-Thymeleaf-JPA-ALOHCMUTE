package hcmute.alohcmute.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.repositories.TaiKhoanRepository;

@Service
public class TaiKhoanServiceImpl implements ITaiKhoanService{
@Autowired
TaiKhoanRepository tkRepo;

public TaiKhoanServiceImpl(TaiKhoanRepository tkRepo) {
	super();
	this.tkRepo = tkRepo;
}

@Override
public <S extends TaiKhoan> S save(S entity) {
	return tkRepo.save(entity);
}

@Override
public List<TaiKhoan> findAll() {
	return tkRepo.findAll();
}

@Override
public Optional<TaiKhoan> findById(Long id) {
	return tkRepo.findById(id);
}

@Override
public boolean existsById(Long id) {
	return tkRepo.existsById(id);
}

@Override
public long count() {
	return tkRepo.count();
}

@Override
public void deleteById(Long id) {
	tkRepo.deleteById(id);
}

}
