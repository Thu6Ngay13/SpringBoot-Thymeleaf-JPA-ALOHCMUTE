package hcmute.alohcmute.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table
public class TaiKhoan implements Serializable{
	private static final long serialVersionUID = -8430672957164998050L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TaiKhoan")
	private int taiKhoan;
	
	@Column(name = "MatKhau")
	private int matKhau;
	
	@OneToOne(mappedBy = "taiKhoan")
    private ThongTinNguoiDung thongTinNguoiDung;
	
	@OneToMany(mappedBy = "taiKhoan", fetch = FetchType.EAGER)
	private List<BaiViet> baiViets;
	
	@ManyToOne
	@JoinColumn(name = "MaLoai")
	private LoaiTaiKhoan loaiTaiKhoan;
	
	@OneToMany(mappedBy = "taiKhoan", fetch = FetchType.EAGER)
	private List<BaiViet> baiViets;
	
	@OneToMany(mappedBy = "taiKhoan", fetch = FetchType.EAGER)
	private List<ThaCamXuc> thaCamXucs;
}
