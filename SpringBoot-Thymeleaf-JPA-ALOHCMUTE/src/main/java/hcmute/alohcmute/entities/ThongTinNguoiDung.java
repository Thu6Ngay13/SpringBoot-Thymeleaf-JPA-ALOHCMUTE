package hcmute.alohcmute.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
