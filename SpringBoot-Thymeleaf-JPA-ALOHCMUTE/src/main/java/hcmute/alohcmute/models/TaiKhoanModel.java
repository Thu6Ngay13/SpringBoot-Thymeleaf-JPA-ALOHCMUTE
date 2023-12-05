package hcmute.alohcmute.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaiKhoanModel {
	
	private String taiKhoan;
	
	private String matKhau;
	private int code;
	private boolean status;
	private String hoTen; 
	private String nickName;
	private String email;
	private String gioiTinh;
	private String sDT;
	private String avatarURl;
}