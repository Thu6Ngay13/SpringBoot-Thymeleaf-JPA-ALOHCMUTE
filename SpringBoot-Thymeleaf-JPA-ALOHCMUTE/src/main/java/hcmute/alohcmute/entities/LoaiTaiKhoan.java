package hcmute.alohcmute.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
@ToString (exclude = {"taiKhoans"})

@Entity
@Table
public class LoaiTaiKhoan implements Serializable{
	private static final long serialVersionUID = 3808802474750908577L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaLoai")
	private int maLoai;
	
	@Column(name = "TenLoai", columnDefinition = "nvarchar(2000)")
	private String tenLoai;
	
	@OneToMany(mappedBy = "loaiTaiKhoan", fetch = FetchType.LAZY)
	private List<TaiKhoan> taiKhoans;
}
