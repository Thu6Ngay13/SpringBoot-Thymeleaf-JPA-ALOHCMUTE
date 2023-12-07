package hcmute.alohcmute.services;

import hcmute.alohcmute.entities.BaoCaoBaiViet;
import hcmute.alohcmute.entities.BaiViet;
import hcmute.alohcmute.repositories.BaoCaoBaiVietRepository;
import hcmute.alohcmute.repositories.BaiVietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class BaoCaoBaiVietServiceImpl implements IBaoCaoBaiVietService {

    @Autowired
    BaoCaoBaiVietRepository baoCaoBaiVietRepository;

    @Autowired
    BaiVietRepository baiVietRepository;

    @Override
    public BaoCaoBaiViet reportPost(int postId, String reason) {
        BaiViet baiViet = baiVietRepository.findById(postId).orElse(null);
        if (baiViet == null) {
            // Handle the case where the post doesn't exist, maybe throw an exception
            return null;
        }

        BaoCaoBaiViet report = new BaoCaoBaiViet();
        report.setBaiViet(baiViet);
        report.setNoiDungBaoCao(reason);
        report.setNgay(LocalDate.now());
        report.setThoiGian(LocalTime.now());
        return baoCaoBaiVietRepository.save(report);
    }
}
