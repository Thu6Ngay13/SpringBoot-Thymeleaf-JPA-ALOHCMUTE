package hcmute.alohcmute.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
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
public class ThongTinNguoiDung implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaNguoiDung")
	private int MaNguoiDung;
	
	@Column(name = "HoTen")
	private String HoTen; 

	@Column(name = "NickName")
	private String NickName;
	
	@Column(name = "Email")
	private String Email;
	
	@Column(name = "GioiTinh")
	private String GioiTinh;
	
	@Column(name = "SDT")
	private String SDT;
	
	@Column(name = "AvatarURL")
	private String AvatarURl;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TaiKhoan")
    private TaiKhoan TaiKhoan;
}
