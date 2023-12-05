package hcmute.alohcmute.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.alohcmute.entities.BaiViet;
import hcmute.alohcmute.repositories.BaiDangRepository;

@Service
public class BaiDangServiceImpl implements IBaiDangService {


    @Autowired
    BaiDangRepository baiDangRepository;

	@Override
	public BaiViet getById(Integer id) {
		return baiDangRepository.getById(id);
	}

	@Override
    public List<BaiViet> findAll() {
        return baiDangRepository.findAll();
    }
}
