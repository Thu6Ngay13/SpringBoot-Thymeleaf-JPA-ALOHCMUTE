package hcmute.alohcmute.services;

import java.util.Optional;

import hcmute.alohcmute.entities.TaiKhoan;

public interface ITaiKhoanService {

	<S extends TaiKhoan> S save(S entity);

	Optional<TaiKhoan> findById(String id);

}
