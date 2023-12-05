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
	TaiKhoanRepository taiKhoanRepository;

	@Override
	public <S extends TaiKhoan> S save(S entity) {
		return taiKhoanRepository.save(entity);
	}
	
	@Override
	public List<TaiKhoan> findAll() {
		return taiKhoanRepository.findAll();
	}

	@Override
	public Optional<TaiKhoan> findById(String id) {
		return taiKhoanRepository.findById(id);
	}
	

	
	@Override
	public boolean existsById(String id) {
		return taiKhoanRepository.existsById(id);
	}

	@Override
	public long count() {
		return taiKhoanRepository.count();
	}
	

	
	@Override
	public void deleteById(String id) {
		taiKhoanRepository.deleteById(id);
	}

	@Override
	public List<TaiKhoan> findTaiKhoanTheoDoisByUsername(String taiKhoanUsername) {
		return taiKhoanRepository.findTaiKhoanTheoDoisByUsername(taiKhoanUsername);
	}
	
	@Override
	public List<TaiKhoan> findTaiKhoanFollowersByUsername(String taiKhoanUsername) {
		return taiKhoanRepository.findTaiKhoanFollowersByUsername(taiKhoanUsername);
	}
	
	@Override
	@Transactional
	public void unfollow(TaiKhoan taiKhoanTheoDoi, TaiKhoan taiKhoanBiTheoDoi) {
	
	        taiKhoanTheoDoi.getTaiKhoanTheoDois().remove(taiKhoanBiTheoDoi);
	   	 	taiKhoanRepository.save(taiKhoanTheoDoi);
	    
	}
	@Override
	public void follow(TaiKhoan taiKhoan, TaiKhoan taiKhoanTheoDoi) {
	
	    taiKhoan.getTaiKhoanTheoDois().add(taiKhoanTheoDoi);
	    taiKhoanRepository.save(taiKhoan);
	}
	
	@Override
	public <S extends TaiKhoan> Optional<S> findOne(Example<S> example) {
		return taiKhoanRepository.findOne(example);
	}
	
	@Override
	public TaiKhoan findBytaiKhoan(String username) {
		return taiKhoanRepository.findOneBytaiKhoan(username);
	}
	
	@Override
	public Map<TaiKhoan, Integer> NguoiTheoDoiChung(String username)
	{
		TaiKhoan ChinhChu = taiKhoanRepository.findOneBytaiKhoan(username);
		Map<TaiKhoan, Integer> result = new HashMap<>();
		List<TaiKhoan> NguoiTheoDoi = taiKhoanRepository.findTaiKhoanTheoDoisByUsername(username);
		for (TaiKhoan taiKhoan : NguoiTheoDoi) {
			List<TaiKhoan> NguoiTheoDoiChung = taiKhoanRepository.findTaiKhoanFollowersByUsername(taiKhoan.getTaiKhoan());
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