package hcmute.alohcmute.services;

import java.util.List;
import java.util.Optional;

import hcmute.alohcmute.entities.TaiKhoan;

public interface ITaiKhoanService {

	void deleteById(String id);

	long count();

	Optional<TaiKhoan> findById(String id);

	List<TaiKhoan> findAll();

	<S extends TaiKhoan> S save(S entity);

}
