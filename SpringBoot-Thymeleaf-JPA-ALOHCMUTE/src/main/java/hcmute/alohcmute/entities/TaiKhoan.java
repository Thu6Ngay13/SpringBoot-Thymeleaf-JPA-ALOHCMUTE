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
	private int TaiKhoan;
	
	@Column(name = "MatKhau")
	private int MatKhau;
	
	@OneToOne(mappedBy = "TaiKhoan")
    private ThongTinNguoiDung ThongTinNguoiDung;
	
	@OneToMany(mappedBy = "TaiKhoan", fetch = FetchType.EAGER)
	private List<BaiViet> BaiViets;
	
	@ManyToOne
	@JoinColumn(name = "MaLoai")
	private LoaiTaiKhoan LoaiTaiKhoan;
	
	@ManyToMany
	@JoinTable(name = "CuocHoiThoai_TaiKhoan",
			joinColumns = {@JoinColumn(name = "TaiKhoan")},
			inverseJoinColumns = {@JoinColumn(name = "MaCuocHoiThoai")})
		private Set<CuocHoiThoai> CuocHoiThoai = new HashSet<CuocHoiThoai>();

	
	
	@ManyToMany
	@JoinTable(name = "Nhom_TaiKhoan",
			joinColumns = {@JoinColumn(name = "TaiKhoan")},
			inverseJoinColumns = {@JoinColumn(name = "MaNhom")})
		private Set<Nhom> Nhom = new HashSet<Nhom>();



}
