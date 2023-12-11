package hcmute.alohcmute.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hcmute.alohcmute.services.BaiVietServiceImpl;
import hcmute.alohcmute.services.IBaiVietService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("user")
public class LikeControllerApi {

	@Autowired
	IBaiVietService baiVietService = new BaiVietServiceImpl();

	@PostMapping("like/{baiVietId}")
	public ResponseEntity<Void> add(@PathVariable(value = "baiVietId") int baiVietId) {
		baiVietService.tangLike(baiVietId, "thuycao816");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("nolike/{baiVietId}")
	public ResponseEntity<Void> delete(@PathVariable(value = "baiVietId") int baiVietId) {
		baiVietService.giamLike(baiVietId, "thuycao816");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
