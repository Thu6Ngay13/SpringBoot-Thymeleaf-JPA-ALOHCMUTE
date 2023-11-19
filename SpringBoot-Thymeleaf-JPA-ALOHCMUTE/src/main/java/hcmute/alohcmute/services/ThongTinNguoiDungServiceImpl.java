package hcmute.alohcmute.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.alohcmute.entities.ThongTinNguoiDung;
import repositories.ThongTinNguoiDungRepository;

@Service
public class ThongTinNguoiDungServiceImpl implements IThongTinNguoiDungService{
	@Autowired
	ThongTinNguoiDungRepository thongTinNguoiDungRepository;

	public ThongTinNguoiDungServiceImpl(ThongTinNguoiDungRepository thongTinNguoiDungRepository) {
		super();
		this.thongTinNguoiDungRepository = thongTinNguoiDungRepository;
	}

	@Override
	public <S extends ThongTinNguoiDung> S save(S entity) {
		return thongTinNguoiDungRepository.save(entity);
	}

	@Override
	public List<ThongTinNguoiDung> findAll() {
		return thongTinNguoiDungRepository.findAll();
	}

	@Override
	public List<ThongTinNguoiDung> findAllById(Iterable<Integer> ids) {
		return thongTinNguoiDungRepository.findAllById(ids);
	}

	@Override
	public Optional<ThongTinNguoiDung> findById(Integer id) {
		return thongTinNguoiDungRepository.findById(id);
	}

	@Override
	public long count() {
		return thongTinNguoiDungRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		thongTinNguoiDungRepository.deleteById(id);
	}
	
	
}
