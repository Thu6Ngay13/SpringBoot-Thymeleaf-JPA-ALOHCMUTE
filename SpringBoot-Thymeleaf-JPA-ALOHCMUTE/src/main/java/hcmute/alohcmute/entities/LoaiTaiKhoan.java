package hcmute.alohcmute.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
public class LoaiTaiKhoan implements Serializable{

	private static final long serialVersionUID = 3808802474750908577L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaLoai")
	private int MaLoai;
	
	@Column(name = "TenLoai")
	private int TenLoai;
	
	@OneToMany(mappedBy = "LoaiTaiKhoan", fetch = FetchType.EAGER)
	private List<TaiKhoan> TaiKhoans;
}
