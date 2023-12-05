package hcmute.alohcmute.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.alohcmute.entities.BaiViet;
import hcmute.alohcmute.repositories.BaiVietRepository;

@Service
public class BaiVietServiceImpl implements IBaiVietService{
	@Autowired
	BaiVietRepository baiVietRepository;

	@Override
	public List<BaiViet> findAll() {
		return baiVietRepository.findAll();
	}

	@Override
	public Optional<BaiViet> findById(Integer id) {
		return baiVietRepository.findById(id);
	}
	
	
	
}
