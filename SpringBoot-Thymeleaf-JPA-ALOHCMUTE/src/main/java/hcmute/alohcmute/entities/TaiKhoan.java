package hcmute.alohcmute.entities;

import java.io.Serializable;
import java.util.List;

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
}
