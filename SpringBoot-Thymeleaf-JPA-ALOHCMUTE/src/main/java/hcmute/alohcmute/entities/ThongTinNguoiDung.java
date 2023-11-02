package hcmute.alohcmute.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor

@Entity
@Table
public class ThongTinNguoiDung {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MaNguoiDung;
	
	@Column
	private String HoTen; 

	@Column
	private String NickName;
	
	@Column
	private String Email;
	
	@Column
	private String GioiTinh;
	
	@Column
	private String SDT;
	
	@Column
	private String AvatarURl;
}
