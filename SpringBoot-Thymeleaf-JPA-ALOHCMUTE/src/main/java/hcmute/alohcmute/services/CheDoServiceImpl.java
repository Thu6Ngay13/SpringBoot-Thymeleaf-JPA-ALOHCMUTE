package hcmute.alohcmute.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.alohcmute.entities.CheDo;
import hcmute.alohcmute.repositories.CheDoRepository;

@Service
public class CheDoServiceImpl implements ICheDoService {

	@Autowired
	CheDoRepository chedoRepo;
	@Override
	public CheDo findByCheDo(String username) {
		return chedoRepo.findOneBytenCheDo(username);
	}

}
