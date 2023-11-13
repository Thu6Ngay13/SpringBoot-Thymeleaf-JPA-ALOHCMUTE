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
@Table
public class BaoCaoBaiViet  implements Serializable{
	private static final long serialVersionUID = -894093677681477663L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaBaoCao")
	private int maBaoCao;
	
	@Column(name = "NoiDungBaoCao")
	private String noiDungBaoCao;
	
	@ManyToOne
	@JoinColumn(name="MaBaiViet")
	private BaiViet baiViet;
}
