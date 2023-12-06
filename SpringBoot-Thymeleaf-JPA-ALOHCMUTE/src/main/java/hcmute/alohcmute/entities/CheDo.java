package hcmute.alohcmute.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class CheDo implements Serializable{
	private static final long serialVersionUID = -3486983368785225071L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaCheDo")
	private int maCheDo;
	
	@Column(name = "TenCheDo", columnDefinition = "nvarchar(2000)")
	private String tenCheDo;
	
	@OneToMany(mappedBy = "cheDoNhom", fetch = FetchType.EAGER)
	private List<Nhom> nhoms;
	
	@OneToMany(mappedBy = "cheDoNhom", fetch = FetchType.EAGER)
	private List<BaiViet> baiViets;
}
