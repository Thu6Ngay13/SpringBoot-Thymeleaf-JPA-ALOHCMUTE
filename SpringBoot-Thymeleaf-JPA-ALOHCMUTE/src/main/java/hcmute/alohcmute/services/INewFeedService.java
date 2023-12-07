package hcmute.alohcmute.services;

import java.util.List;

import hcmute.alohcmute.entities.BaiViet;

public interface INewFeedService {
    List<BaiViet> findAll();
    List<BaiViet> findPublicOrFollowedPosts(String currentUsername);
}