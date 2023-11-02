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
@Table(name="CheDoNhom")
public class CheDoNhom  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MaCheDo;
	@Column
	private String TenCheDo;
	
	@OneToMany(mappedBy = "CheDoNhom", fetch=FetchType.EAGER)
	private List<Nhom> Nhoms;
	
	
	@OneToMany(mappedBy = "BaiViet" , fetch=FetchType.EAGER)
	private List<BaiViet> BaiViets;
	
	
}
