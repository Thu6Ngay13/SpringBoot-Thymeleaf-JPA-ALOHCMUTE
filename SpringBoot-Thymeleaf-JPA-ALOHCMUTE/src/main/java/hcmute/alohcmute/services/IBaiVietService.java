package hcmute.alohcmute.services;

import java.util.List;
import java.util.Optional;

import hcmute.alohcmute.entities.BaiViet;

public interface IBaiVietService {

	Optional<BaiViet> findById(Integer id);

	List<BaiViet> findAll();

}
