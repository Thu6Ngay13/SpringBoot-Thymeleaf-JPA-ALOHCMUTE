package hcmute.alohcmute.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.alohcmute.entities.BaiViet;
import hcmute.alohcmute.entities.TaiKhoan;
import hcmute.alohcmute.repositories.BaiVietRepository;

@Service
public class NewFeedServiceImpl implements INewFeedService {

	@Autowired
	BaiVietRepository baiVietRepository;

	public NewFeedServiceImpl(BaiVietRepository baiVietRepository) {
		this.baiVietRepository = baiVietRepository;
	}

	@Override
	public List<BaiViet> findAll() {
		return baiVietRepository.findAll();
	}

	@Autowired
	ITaiKhoanService taiKhoanService;

	// Other existing methods...
	@Override
	public List<BaiViet> findPublicOrFollowedPosts(String currentUsername) {
		// Define how public posts are denoted in your application

		// Get the list of TaiKhoan entities that the current user follows
		List<TaiKhoan> followedUsers = taiKhoanService.findTaiKhoanTheoDoisByUsername(currentUsername);
		System.out.println(followedUsers.size());
		List<BaiViet> bv = baiVietRepository.findAll();
		List<BaiViet> kq = new ArrayList<>();
		for (BaiViet baiViet : bv) {
			if (baiViet.getCheDoNhom().getTenCheDo().equals("Công khai")) {
				kq.add(baiViet);
			} else if (baiViet.getCheDoNhom().getTenCheDo().equals("Người theo dõi")) {
				if (followedUsers.contains(baiViet.getTaiKhoan()))
					kq.add(baiViet);
			} else if (baiViet.getTaiKhoan().getTaiKhoan().equals(currentUsername))
				kq.add(baiViet);
		}

		return kq;
	}
}
