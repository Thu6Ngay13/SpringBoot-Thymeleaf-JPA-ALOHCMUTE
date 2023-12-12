package hcmute.alohcmute.services;

import java.util.Optional;

import hcmute.alohcmute.entities.CheDo;

public interface ICheDoService {

	Optional<CheDo> findById(Integer id);

}
