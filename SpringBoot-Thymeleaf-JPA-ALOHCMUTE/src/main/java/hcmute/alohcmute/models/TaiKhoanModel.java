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
	private long soLuongNguoiTheoDoi;
	private boolean isfollowed;
	public TaiKhoanModel(String taiKhoan, String matKhau, int code, boolean status, String hoTen, String nickName,
			String email, String gioiTinh, String sDT, String avatarURl) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.code = code;
		this.status = status;
		this.hoTen = hoTen;
		this.nickName = nickName;
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.sDT = sDT;
		this.avatarURl = avatarURl;
	}
	public TaiKhoanModel(String taiKhoan, String matKhau, int code, boolean status, String hoTen, String nickName,
			String email, String gioiTinh, String sDT, String avatarURl, long soLuongNguoiTheoDoi) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.code = code;
		this.status = status;
		this.hoTen = hoTen;
		this.nickName = nickName;
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.sDT = sDT;
		this.avatarURl = avatarURl;
		this.soLuongNguoiTheoDoi = soLuongNguoiTheoDoi;
	}
	
}
