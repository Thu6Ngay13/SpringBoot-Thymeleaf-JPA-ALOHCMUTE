package hcmute.alohcmute.entities;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name="TinNhan")
public class TinNhan implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MaTinNhan;
	@Column(columnDefinition = "nvarchar(5000)")
	private String NoiDungChu;
	@Column
	private String NoiDungHinhAnh;
	@Column
	private Date ThoiGianGuiTinNhan;
	
	@ManyToOne
	@JoinColumn(name="MaCuocHoiThoai")
	private CuocHoiThoai CuocHoiThoai;

	
	
	
	public TinNhan() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TinNhan [MaTinNhan=" + MaTinNhan + ", NoiDungChu=" + NoiDungChu + ", NoiDungHinhAnh=" + NoiDungHinhAnh
				+ ", ThoiGianGuiTinNhan=" + ThoiGianGuiTinNhan + ", CuocHoiThoai=" + CuocHoiThoai + "]";
	}

	public TinNhan(int maTinNhan, String noiDungChu, String noiDungHinhAnh, Date thoiGianGuiTinNhan,
			hcmute.alohcmute.entities.CuocHoiThoai cuocHoiThoai) {
		super();
		MaTinNhan = maTinNhan;
		NoiDungChu = noiDungChu;
		NoiDungHinhAnh = noiDungHinhAnh;
		ThoiGianGuiTinNhan = thoiGianGuiTinNhan;
		CuocHoiThoai = cuocHoiThoai;
	}

	public int getMaTinNhan() {
		return MaTinNhan;
	}

	public void setMaTinNhan(int maTinNhan) {
		MaTinNhan = maTinNhan;
	}

	public String getNoiDungChu() {
		return NoiDungChu;
	}

	public void setNoiDungChu(String noiDungChu) {
		NoiDungChu = noiDungChu;
	}

	public String getNoiDungHinhAnh() {
		return NoiDungHinhAnh;
	}

	public void setNoiDungHinhAnh(String noiDungHinhAnh) {
		NoiDungHinhAnh = noiDungHinhAnh;
	}

	public Date getThoiGianGuiTinNhan() {
		return ThoiGianGuiTinNhan;
	}

	public void setThoiGianGuiTinNhan(Date thoiGianGuiTinNhan) {
		ThoiGianGuiTinNhan = thoiGianGuiTinNhan;
	}

	public CuocHoiThoai getCuocHoiThoai() {
		return CuocHoiThoai;
	}

	public void setCuocHoiThoai(CuocHoiThoai cuocHoiThoai) {
		CuocHoiThoai = cuocHoiThoai;
	}

	
	
	


}
