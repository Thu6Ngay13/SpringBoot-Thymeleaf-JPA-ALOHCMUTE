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
}
