package hcmute.alohcmute.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.alohcmute.entities.Nhom;
import hcmute.alohcmute.repositories.NhomRepository;

@Service
public class NhomServiceImpl implements INhomService {

	@Autowired
	NhomRepository nhomRepo;
	
	public NhomServiceImpl(NhomRepository nhomRepo) {
		this.nhomRepo = nhomRepo;
	}
	@Override
	public Nhom findBymaNhom(int maNhom) {
		return nhomRepo.findBymaNhom(maNhom);
	}

	@Override
    public List<Nhom> findByTenNhomContainingIgnoreCase(String searchString){
		return nhomRepo.findByTenNhomContainingIgnoreCase(searchString);
	}

}
