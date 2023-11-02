package hcmute.alohcmute.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
	@Column
	private BaiViet BaiViet;
	
	@Id
	private IconCamXuc IconCamXuc;
	
	@Id
	private TaiKhoan TaiKhoan;	
}
