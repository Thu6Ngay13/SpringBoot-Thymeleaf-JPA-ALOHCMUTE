package hcmute.alohcmute.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor

@Entity
@Table(name="CheDoNhom")
public class CheDoNhom implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maCheDo;
	
	@Column
	private String TenCheDo;
	
	@OneToMany(mappedBy = "cheDoNhom", fetch = FetchType.EAGER)
	private List<Nhom> nhoms;
	
	@OneToMany(mappedBy = "cheDoNhom", fetch = FetchType.EAGER)
	private List<BaiViet> baiViets;
}
