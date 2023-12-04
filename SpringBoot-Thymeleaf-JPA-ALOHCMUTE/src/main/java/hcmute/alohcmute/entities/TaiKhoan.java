package hcmute.alohcmute.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return this.taiKhoan==other.getTaiKhoan();
	}

	@Override
	public int hashCode() {
		return Objects.hash(taiKhoan);
	}
	
	
}
