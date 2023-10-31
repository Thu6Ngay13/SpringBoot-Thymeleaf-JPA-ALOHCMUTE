package hcmute.alohcmute.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor

@Entity
@Table
public class CheDoNhom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MaCheDo;
	
	@Column
	private String TenCheDo;
}
