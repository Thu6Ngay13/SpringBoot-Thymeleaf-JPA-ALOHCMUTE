package hcmute.alohcmute.services;

import java.util.List;

import hcmute.alohcmute.entities.BaiViet;

public interface IBaiDangService {
    List<BaiViet> findAll();

	BaiViet getById(Integer id);
}