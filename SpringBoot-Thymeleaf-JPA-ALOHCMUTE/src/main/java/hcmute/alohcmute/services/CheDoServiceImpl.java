package hcmute.alohcmute.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.alohcmute.entities.CheDo;
import hcmute.alohcmute.repositories.CheDoRepository;

@Service
public class CheDoServiceImpl implements ICheDoService{
	
	@Autowired
	CheDoRepository cheDoRepository;

	@Override
	public Optional<CheDo> findById(Integer id) {
		return cheDoRepository.findById(id);
	}
	
	
}
