package hcmute.alohcmute.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@NoArgsConstructor 
@AllArgsConstructor

@Entity
@Table(name="Nhom")

public class Nhom  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maNhom;

	@Column(columnDefinition = "nvarchar(200)")
	private String tenNhom;

	@Column(columnDefinition = "nvarchar(200)")
	private String ngayThanhLap;
	
	@ManyToOne
	@JoinColumn(name="MaCheDo")
	private CheDoNhom cheDoNhom;
	
	@ManyToMany(mappedBy = "nhom")
	private Set<TaiKhoan> taiKhoans = new HashSet<TaiKhoan>();
	
}
