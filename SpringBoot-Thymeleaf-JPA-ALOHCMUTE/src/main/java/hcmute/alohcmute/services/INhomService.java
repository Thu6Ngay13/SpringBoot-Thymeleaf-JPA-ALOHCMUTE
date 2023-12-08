package hcmute.alohcmute.services;

import java.util.List;

import hcmute.alohcmute.entities.Nhom;

public interface INhomService {

	Nhom findBymaNhom (int maNhom);

	List<Nhom> findByTenNhomContainingIgnoreCase(String searchString);

}
