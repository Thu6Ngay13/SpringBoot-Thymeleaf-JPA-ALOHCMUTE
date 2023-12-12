package hcmute.alohcmute.services;

import java.util.List;
import java.util.Optional;

import hcmute.alohcmute.entities.TinNhan;

public interface ITinNhanService  {

	long count();

	Optional<TinNhan> findById(Integer id);

	List<TinNhan> findAll();

	List<TinNhan> findByMaCuocHoiThoai(int maCuocHoiThoai);

}
