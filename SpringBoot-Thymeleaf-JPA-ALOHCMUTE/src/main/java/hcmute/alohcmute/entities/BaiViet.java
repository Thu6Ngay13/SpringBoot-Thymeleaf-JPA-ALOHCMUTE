package hcmute.alohcmute.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
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
	private Set<BinhLuan> binhLuans;
	
	@ManyToOne
	@JoinColumn(name = "taiKhoan")
	private TaiKhoan taiKhoan;
	
	@OneToMany(mappedBy = "baiViet")
	private Set<BaoCaoBaiViet> baoCaoBaiViets;

	@ManyToMany(mappedBy = "baiVietTuongTacs")
	private Set<TaiKhoan> taiKhoans = new HashSet<TaiKhoan>();
	
	@ManyToOne
	@JoinColumn(name = "MaNhom")
	private Nhom nhom;
}
