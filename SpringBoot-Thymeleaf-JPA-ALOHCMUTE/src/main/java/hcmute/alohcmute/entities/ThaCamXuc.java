package hcmute.alohcmute.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor

@Entity
@Table
public class ThaCamXuc {
	@OneToOne
	@JoinColumn(name = "thaCamXuc")
	private IconCamXuc iconCamXuc;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "MaBaiViet")
	private BaiViet baiViet;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "taiKhoan")
	private TaiKhoan taiKhoan;	
}
