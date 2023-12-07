package hcmute.alohcmute.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.alohcmute.entities.BaiViet;
import hcmute.alohcmute.repositories.BaiVietRepository;

@Service
public class BaiVietServiceImpl implements IBaiVietService {

	@Autowired
	BaiVietRepository baivietrepo;
	
	@Override
	public <S extends BaiViet> S save(S entity) {
		return baivietrepo.save(entity);
	}

}
