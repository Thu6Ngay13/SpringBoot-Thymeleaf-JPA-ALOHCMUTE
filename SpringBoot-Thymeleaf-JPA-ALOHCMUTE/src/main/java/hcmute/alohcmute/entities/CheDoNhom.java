package hcmute.alohcmute.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table
public class CheDoNhom implements Serializable{

	private static final long serialVersionUID = -1383740467103010145L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaCheDo")
	private int MaCheDo;
	
	@Column(name = "TenCheDo")
	private String TenCheDo;
	
	@OneToMany(mappedBy = "CheDoNhom", fetch = FetchType.EAGER)
	private List<Nhom> Nhoms;
	
	@OneToMany(mappedBy = "CheDONhom", fetch = FetchType.EAGER)
	private List<BaiViet> BaiViets;
}
