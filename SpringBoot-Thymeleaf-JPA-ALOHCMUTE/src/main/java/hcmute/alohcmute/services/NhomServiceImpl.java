package hcmute.alohcmute.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.alohcmute.entities.Nhom;
import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.entities.TaiKhoan_Nhom;
import hcmute.alohcmute.entities.TaiKhoan_Nhom_Id;
import hcmute.alohcmute.repositories.NhomRepository;
import hcmute.alohcmute.repositories.TaiKhoan_NhomRepository;

@Service
public class NhomServiceImpl implements INhomService {

	@Autowired
	NhomRepository nhomRepo;
	@Autowired
	TaiKhoan_NhomRepository tkNhomRepo;

	public NhomServiceImpl(NhomRepository nhomRepo) {
		this.nhomRepo = nhomRepo;
	}

	@Override
	public Nhom findBymaNhom(int maNhom) {
		return nhomRepo.findBymaNhom(maNhom);
	}

	@Override
	public List<Nhom> findByTenNhomContainingIgnoreCase(String searchString) {
		return nhomRepo.findByTenNhomContainingIgnoreCase(searchString);
	}

	@Override
	public void sendRequestToGroup(TaiKhoan tk, Nhom gr) {
		TaiKhoan_Nhom taikhoanNhom = new TaiKhoan_Nhom();
		taikhoanNhom.setId(new TaiKhoan_Nhom_Id(gr.getMaNhom(),tk.getTaiKhoan()));
		taikhoanNhom.setAccept(false);
		tkNhomRepo.save(taikhoanNhom);
	}
	
	@Override
	public void leaveGroup(String tk, int nhom) {
		TaiKhoan_Nhom taikhoanNhom = tkNhomRepo.findOne(tk, nhom);
		
		tkNhomRepo.delete(taikhoanNhom);
	}
	
	@Override
	public void addMember(String tk, int nhom) {
		TaiKhoan_Nhom taikhoanNhom = tkNhomRepo.findOne(tk, nhom);
		taikhoanNhom.setAccept(true);
		tkNhomRepo.save(taikhoanNhom);
	}
	
	@Override
	public List<TaiKhoan_Nhom> findNhomTaiKhoan(String taiKhoan){
    	return tkNhomRepo.findNhomTaiKhoan(taiKhoan);
    }
	
	@Override
	public List<TaiKhoan_Nhom> findAllTK_Nhom()
	{
		return tkNhomRepo.findAll();
	}
	
	@Override
	public List<TaiKhoan_Nhom> findTaiKhoanByNhom(int maNhom) {
		return tkNhomRepo.findTaiKhoanByNhom(maNhom);
	}
	@Override
	public void Save(Nhom nhom) {
		nhomRepo.save(nhom);
	}


}
