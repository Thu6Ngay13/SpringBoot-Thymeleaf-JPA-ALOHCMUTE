package hcmute.alohcmute.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table
public class CuocHoiThoai implements Serializable {
	private static final long serialVersionUID = -269845602203068297L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaCuocHoiThoai")
	private int maCuocHoiThoai;

	@Column(name = "TenCuocHoiThoai", columnDefinition = "nvarchar(2000)")
	private String tenCuocHoiThoai;

	@OneToMany(mappedBy = "cuocHoiThoai", fetch = FetchType.EAGER)
	private List<TinNhan> tinNhans;

	@ManyToMany(mappedBy = "cuocHoiThoai")
	private Set<TaiKhoan> taiKhoans;

}
