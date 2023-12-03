package hcmute.alohcmute.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table
public class TaiKhoan implements Serializable{
	private static final long serialVersionUID = -8430672957164998050L;
	
	@Id
	@Column(name = "TaiKhoan", columnDefinition = "nvarchar(2000)")
	private String taiKhoan;
	
	@Column(name = "MatKhau", columnDefinition = "varchar(2000)")
	private String matKhau;
	
	@Column(name = "Code")
	private int code;
	
	@Column(name = "Status", columnDefinition = "bit")
	private boolean status;
	
	@Column(name = "HoTen", columnDefinition = "nvarchar(2000)")
	private String hoTen; 

	@Column(name = "NickName", columnDefinition = "nvarchar(2000)")
	private String nickName;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "GioiTinh")
	private String gioiTinh;
	
	@Column(name = "SDT")
	private String sDT;
	
	@Column(name = "AvatarURL", columnDefinition = "nvarchar(2000)")
	private String avatarURl;
	
	@ManyToOne
	@JoinColumn(name = "MaLoai")
	private LoaiTaiKhoan loaiTaiKhoan;
	
	@OneToMany(mappedBy = "taiKhoan", fetch = FetchType.EAGER)
	private List<BaiViet> baiViets;
	
	@ManyToMany
	@JoinTable(name = "TaiKhoan_CuocHoiThoai",
		joinColumns = {@JoinColumn(name = "TaiKhoan") },
		inverseJoinColumns = {@JoinColumn(name = "MaCuocHoiThoai")})
	private Set<CuocHoiThoai> cuocHoiThoai = new HashSet<CuocHoiThoai>();
	
	@ManyToMany
	@JoinTable(name = "TaiKhoan_Nhom",
		joinColumns = {@JoinColumn(name = "TaiKhoan") },
		inverseJoinColumns = {@JoinColumn(name = "MaNhom")})
	private Set<Nhom> nhom = new HashSet<Nhom>();
	
	@ManyToMany
	@JoinTable(name = "TaiKhoan_TheoDoi_TaiKhoan",
		joinColumns = {@JoinColumn(name = "TaiKhoanTheoDoi") },
		inverseJoinColumns = {@JoinColumn(name = "TaiKhoanBiTheoDoi")})
	private Set<TaiKhoan> taiKhoanTheoDois = new HashSet<TaiKhoan>();
	
	@ManyToMany
	@JoinTable(name = "TaiKhoan_Chan_TaiKhoan",
		joinColumns = {@JoinColumn(name = "TaiKhoanChan") },
		inverseJoinColumns = {@JoinColumn(name = "TaiKhoanBiChan")})
	private Set<TaiKhoan> taiKhoanChans = new HashSet<TaiKhoan>();
	
	@OneToMany(mappedBy = "taiKhoan", fetch = FetchType.EAGER)
	private Set<ThongBao> thongBaos;
	
	@OneToMany(mappedBy = "taiKhoan", fetch = FetchType.EAGER)
	private Set<BinhLuan> binhLuans;

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getsDT() {
		return sDT;
	}

	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

	public String getAvatarURl() {
		return avatarURl;
	}

	public void setAvatarURl(String avatarURl) {
		this.avatarURl = avatarURl;
	}

	public LoaiTaiKhoan getLoaiTaiKhoan() {
		return loaiTaiKhoan;
	}

	public void setLoaiTaiKhoan(LoaiTaiKhoan loaiTaiKhoan) {
		this.loaiTaiKhoan = loaiTaiKhoan;
	}

	public List<BaiViet> getBaiViets() {
		return baiViets;
	}

	public void setBaiViets(List<BaiViet> baiViets) {
		this.baiViets = baiViets;
	}

	public Set<CuocHoiThoai> getCuocHoiThoai() {
		return cuocHoiThoai;
	}

	public void setCuocHoiThoai(Set<CuocHoiThoai> cuocHoiThoai) {
		this.cuocHoiThoai = cuocHoiThoai;
	}

	public Set<Nhom> getNhom() {
		return nhom;
	}

	public void setNhom(Set<Nhom> nhom) {
		this.nhom = nhom;
	}

	public Set<TaiKhoan> getTaiKhoanTheoDois() {
		return taiKhoanTheoDois;
	}

	public void setTaiKhoanTheoDois(Set<TaiKhoan> taiKhoanTheoDois) {
		this.taiKhoanTheoDois = taiKhoanTheoDois;
	}

	public Set<TaiKhoan> getTaiKhoanChans() {
		return taiKhoanChans;
	}

	public void setTaiKhoanChans(Set<TaiKhoan> taiKhoanChans) {
		this.taiKhoanChans = taiKhoanChans;
	}

	public Set<ThongBao> getThongBaos() {
		return thongBaos;
	}

	public void setThongBaos(Set<ThongBao> thongBaos) {
		this.thongBaos = thongBaos;
	}

	public Set<BinhLuan> getBinhLuans() {
		return binhLuans;
	}

	public void setBinhLuans(Set<BinhLuan> binhLuans) {
		this.binhLuans = binhLuans;
	}
	
	
}
