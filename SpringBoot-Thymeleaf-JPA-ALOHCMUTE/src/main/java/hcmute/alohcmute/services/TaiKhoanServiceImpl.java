package hcmute.alohcmute.services;


import java.util.HashMap;


import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.repositories.TaiKhoanRepository;

@Service
public class TaiKhoanServiceImpl implements ITaiKhoanService{
	@Autowired
	TaiKhoanRepository tkRepo;
	
	public TaiKhoanServiceImpl(TaiKhoanRepository tkRepo) {
		super();
		this.tkRepo = tkRepo;
	}
	
	@Override
	public <S extends TaiKhoan> S save(S entity) {
		return tkRepo.save(entity);
	}
	
	@Override
	public List<TaiKhoan> findAll() {
		return tkRepo.findAll();
	}
	
	@Override
	public Optional<TaiKhoan> findById(Long id) {
		return tkRepo.findById(id);
	}
	
	@Override
	public boolean existsById(Long id) {
		return tkRepo.existsById(id);
	}
	
	@Override
	public long count() {
		return tkRepo.count();
	}
	
	@Override
	public void deleteById(Long id) {
		tkRepo.deleteById(id);
	}
	
	@Override
	public List<TaiKhoan> findTaiKhoanTheoDoisByUsername(String taiKhoanUsername) {
		return tkRepo.findTaiKhoanTheoDoisByUsername(taiKhoanUsername);
	}
	
	@Override
	public List<TaiKhoan> findTaiKhoanFollowersByUsername(String taiKhoanUsername) {
		return tkRepo.findTaiKhoanFollowersByUsername(taiKhoanUsername);
	}
	
	@Override
	@Transactional
	public void unfollow(TaiKhoan taiKhoanTheoDoi, TaiKhoan taiKhoanBiTheoDoi) {
	
	        taiKhoanTheoDoi.getTaiKhoanTheoDois().remove(taiKhoanBiTheoDoi);
	   	 	tkRepo.save(taiKhoanTheoDoi);
	    
	}
	@Override
	public void follow(TaiKhoan taiKhoan, TaiKhoan taiKhoanTheoDoi) {
	
	    taiKhoan.getTaiKhoanTheoDois().add(taiKhoanTheoDoi);
	    tkRepo.save(taiKhoan);
	}
	
	public <S extends TaiKhoan> Optional<S> findOne(Example<S> example) {
		return tkRepo.findOne(example);
	}
	
	@Override
	public TaiKhoan findBytaiKhoan(String username) {
		return tkRepo.findOneBytaiKhoan(username);
	}
	
	@Override
	public Map<TaiKhoan, Integer> NguoiTheoDoiChung(String username)
	{
		TaiKhoan ChinhChu = tkRepo.findOneBytaiKhoan(username);
		Map<TaiKhoan, Integer> result = new HashMap<>();
		List<TaiKhoan> NguoiTheoDoi = tkRepo.findTaiKhoanTheoDoisByUsername(username);
		for (TaiKhoan taiKhoan : NguoiTheoDoi) {
			List<TaiKhoan> NguoiTheoDoiChung = tkRepo.findTaiKhoanFollowersByUsername(taiKhoan.getTaiKhoan());
			for (TaiKhoan taiKhoan2 : NguoiTheoDoiChung) {
				if (!NguoiTheoDoi.contains(taiKhoan2) && !taiKhoan2.equals(ChinhChu))
				if (result.containsKey(taiKhoan2)) {
					int a = result.get(taiKhoan2);
					a=a+1;
					result.put(taiKhoan2, a);
				}
				else {
					result.put(taiKhoan2, 1);
				}	
			}
		}
		
		return result;
	}


}
