package hcmute.alohcmute.services;

import java.util.ArrayList;
import java.util.Collections;
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
	    // Get the list of TaiKhoan entities that the current user follows
	    List<TaiKhoan> followedUsers = taiKhoanService.findTaiKhoanTheoDoisByUsername(currentUsername);
	    System.out.println(followedUsers.size());
	    List<BaiViet> allPosts = baiVietRepository.findAll();
	    List<BaiViet> eligiblePosts = new ArrayList<>();

	    for (BaiViet baiViet : allPosts) {
	        if (baiViet.getCheDoNhom().getTenCheDo().equals("Công khai") || 
	            (baiViet.getCheDoNhom().getTenCheDo().equals("Người theo dõi") && followedUsers.contains(baiViet.getTaiKhoan())) || 
	            baiViet.getTaiKhoan().getTaiKhoan().equals(currentUsername)) {
	            eligiblePosts.add(baiViet);
	        }
	    }

	    // Sort eligible posts by date and time in descending order
	    List<BaiViet> sortedPosts = eligiblePosts.stream()
	           .sorted((bv1, bv2) -> {
	               int dateCompare = bv2.getNgay().compareTo(bv1.getNgay());
	               if (dateCompare == 0) {
	                   return bv2.getThoiGian().compareTo(bv1.getThoiGian());
	               }
	               return dateCompare;
	           })
	           .collect(Collectors.toList());

	    // Extract and shuffle the top 20 recent posts
	    List<BaiViet> top20Posts = new ArrayList<>(sortedPosts.stream().limit(20).collect(Collectors.toList()));
	    Collections.shuffle(top20Posts);

	    // Remove the original top 20 posts from the sorted list
	    sortedPosts.subList(0, Math.min(20, sortedPosts.size())).clear();

	    // Add the shuffled top 20 posts back to the sorted list
	    sortedPosts.addAll(0, top20Posts);

	    return sortedPosts;
	
	}

}
