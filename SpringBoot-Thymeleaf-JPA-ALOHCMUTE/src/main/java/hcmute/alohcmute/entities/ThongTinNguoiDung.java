package hcmute.alohcmute.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data 
@NoArgsConstructor 
@AllArgsConstructor

@Entity
@Table
public class ThongTinNguoiDung implements Serializable {
	private static final long serialVersionUID = 6957281178392839308L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaNguoiDung")
	private int maNguoiDung;
	
	@Column(name = "HoTen")
	private String hoTen; 

	@Column(name = "NickName")
	private String nickName;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "GioiTinh")
	private String gioiTinh;
	
	@Column(name = "SDT")
	private String sDT;
	
	@Column(name = "AvatarURL", columnDefinition = "nvarchar(2000)")
	private String avatarURl;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TaiKhoan")
    private TaiKhoan taiKhoan;
}
