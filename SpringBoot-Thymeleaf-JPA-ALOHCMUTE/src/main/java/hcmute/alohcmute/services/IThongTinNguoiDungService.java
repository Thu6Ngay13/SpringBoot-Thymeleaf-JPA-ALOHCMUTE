package hcmute.alohcmute.services;

import java.util.List;
import java.util.Optional;

import hcmute.alohcmute.entities.ThongTinNguoiDung;

public interface IThongTinNguoiDungService {

	void deleteById(Integer id);

	long count();

	Optional<ThongTinNguoiDung> findById(Integer id);

	List<ThongTinNguoiDung> findAllById(Iterable<Integer> ids);

	List<ThongTinNguoiDung> findAll();

	<S extends ThongTinNguoiDung> S save(S entity);

}
