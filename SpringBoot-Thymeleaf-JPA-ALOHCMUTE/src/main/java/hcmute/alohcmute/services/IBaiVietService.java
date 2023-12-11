package hcmute.alohcmute.services;

import java.util.List;

import hcmute.alohcmute.entities.BaiViet;
import hcmute.alohcmute.entities.Nhom;

public interface IBaiVietService {

	<S extends BaiViet> S save(S entity);


	List<BaiViet> findBymaNhom(Nhom Nhom);
	BaiViet findBymaBaiViet(int mabv);

}
