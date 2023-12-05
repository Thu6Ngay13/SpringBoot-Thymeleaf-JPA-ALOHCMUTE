package hcmute.alohcmute.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor

@Entity
@Table
public class BaoCaoBaiViet  implements Serializable{
	private static final long serialVersionUID = -894093677681477663L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaBaoCao")
	private int maBaoCao;
	
	@Column(name = "NoiDungBaoCao", columnDefinition = "nvarchar(2000)")
	private String noiDungBaoCao;
	
	@Column(name = "ThoiGian", columnDefinition = "Time")
	private LocalTime ThoiGian;
	
	@Column(name = "Ngay", columnDefinition = "Date")
	private LocalDate Ngay;
	
	@ManyToOne
	@JoinColumn(name="MaBaiViet")
	private BaiViet baiViet;

	public int getMaBaoCao() {
		return maBaoCao;
	}

	public void setMaBaoCao(int maBaoCao) {
		this.maBaoCao = maBaoCao;
	}

	public String getNoiDungBaoCao() {
		return noiDungBaoCao;
	}

	public void setNoiDungBaoCao(String noiDungBaoCao) {
		this.noiDungBaoCao = noiDungBaoCao;
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

	public BaiViet getBaiViet() {
		return baiViet;
	}

	public void setBaiViet(BaiViet baiViet) {
		this.baiViet = baiViet;
	}


	@Override
	public String toString() {
		return "BaoCaoBaiViet [maBaoCao=" + maBaoCao + ", noiDungBaoCao=" + noiDungBaoCao + ", ThoiGian=" + ThoiGian
				+ ", Ngay=" + Ngay + ", baiViet=" + baiViet + "]";
	}
	
	
}
