package hcmute.alohcmute.entities;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table
public class ThongTinNguoiDung implements Serializable{
	
	private static final long serialVersionUID = 5684183710155518782L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaNguoiDung")
	private int MaNguoiDung;
	
	@Column(name = "HoTen")
	private String HoTen; 

	@Column(name = "NickName")
	private String NickName;
	
	@Column(name = "Email")
	private String Email;
	
	@Column(name = "GioiTinh")
	private String GioiTinh;
	
	@Column(name = "SDT")
	private String SDT;
	
	@Column(name = "AvatarURL")
	private String AvatarURl;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TaiKhoan")
    private TaiKhoan TaiKhoan;
}
