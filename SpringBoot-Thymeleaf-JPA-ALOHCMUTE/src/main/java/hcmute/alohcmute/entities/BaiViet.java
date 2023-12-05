package hcmute.alohcmute.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
@EqualsAndHashCode(exclude="taiKhoan")
@ToString (exclude = {"binhLuans", "baoCaoBaiViets"})


@Entity
@Table
public class BaiViet implements Serializable {
	private static final long serialVersionUID = 3982734050186550748L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaBaiViet")
	private int maBaiViet;
	
	@Column(name = "NoiDungChu", columnDefinition = "nvarchar(2000)")
	private String noiDungChu;
	
	@Column(name = "NoiDungHinhAnh", columnDefinition = "nvarchar(2000)")
	private String noiDungHinhAnh;
	
	@Column(name = "ThoiGian", columnDefinition = "Time")
	private LocalTime  ThoiGian;
	
	@Column(name = "Ngay", columnDefinition = "Date")
	private LocalDate Ngay;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "MaCheDo")
	private CheDo cheDoNhom;
	
	@OneToMany(mappedBy = "baiViet", fetch = FetchType.EAGER)
	private List<BinhLuan> binhLuans;
	
	@ManyToOne
	@JoinColumn(name = "taiKhoan")
	private TaiKhoan taiKhoan;
	
	@OneToMany(mappedBy = "baiViet")
	private List<BaoCaoBaiViet> baoCaoBaiViets;

	public int getMaBaiViet() {
		return maBaiViet;
	}

	public void setMaBaiViet(int maBaiViet) {
		this.maBaiViet = maBaiViet;
	}

	public String getNoiDungChu() {
		return noiDungChu;
	}

	public void setNoiDungChu(String noiDungChu) {
		this.noiDungChu = noiDungChu;
	}

	public String getNoiDungHinhAnh() {
		return noiDungHinhAnh;
	}

	public void setNoiDungHinhAnh(String noiDungHinhAnh) {
		this.noiDungHinhAnh = noiDungHinhAnh;
	}

	public LocalTime getThoiGian() {
		return ThoiGian;
	}

	public void setThoiGian(LocalTime thoiGian) {
		ThoiGian = thoiGian;
	}

	public LocalDate getNgay() {
		return Ngay;
	}

	public void setNgay(LocalDate ngay) {
		Ngay = ngay;
	}

	public CheDo getCheDoNhom() {
		return cheDoNhom;
	}

	public void setCheDoNhom(CheDo cheDoNhom) {
		this.cheDoNhom = cheDoNhom;
	}

	public List<BinhLuan> getBinhLuans() {
		return binhLuans;
	}

	public void setBinhLuans(List<BinhLuan> binhLuans) {
		this.binhLuans = binhLuans;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public List<BaoCaoBaiViet> getBaoCaoBaiViets() {
		return baoCaoBaiViets;
	}

	public void setBaoCaoBaiViets(List<BaoCaoBaiViet> baoCaoBaiViets) {
		this.baoCaoBaiViets = baoCaoBaiViets;
	}
	
	
	
	@ManyToMany(mappedBy = "baiVietTuongTacs")
	private Set<TaiKhoan> taiKhoans = new HashSet<TaiKhoan>();
	
	@ManyToOne
	@JoinColumn(name = "MaNhom")
	private Nhom nhom;
}
