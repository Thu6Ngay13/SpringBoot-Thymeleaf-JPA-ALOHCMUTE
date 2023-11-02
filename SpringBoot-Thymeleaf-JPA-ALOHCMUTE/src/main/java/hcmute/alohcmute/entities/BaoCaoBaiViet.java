package hcmute.alohcmute.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor

@Entity
@Table(name="BaoCaoBaiViet")
public class BaoCaoBaiViet  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MaBaoCao;
	@Column (columnDefinition = "nvarchar(5000)")
	private String NoiDungBaoCao;
	@ManyToOne
	@JoinColumn(name="MaBaiViet")
	private BaiViet BaiViet;
	
	
	
	
}
