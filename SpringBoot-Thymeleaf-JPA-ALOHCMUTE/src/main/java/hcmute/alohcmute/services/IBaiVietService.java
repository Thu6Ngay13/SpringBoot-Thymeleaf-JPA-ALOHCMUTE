package hcmute.alohcmute.services;

import hcmute.alohcmute.entities.BaiViet;

public interface IBaiVietService {

	<S extends BaiViet> S save(S entity);

}
