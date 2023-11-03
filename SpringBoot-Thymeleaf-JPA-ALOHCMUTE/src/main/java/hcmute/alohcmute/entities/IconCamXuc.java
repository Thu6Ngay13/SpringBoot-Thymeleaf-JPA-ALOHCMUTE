package hcmute.alohcmute.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@NoArgsConstructor 
@AllArgsConstructor

@Entity
@Table
@NamedQuery(name="IconCamXuc.findAll", query="SELECT cx FROM IconCamXuc cx")
public class IconCamXuc implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaCamXuc")
	private int maCamXuc;
	
	@Column(name = "HinhAnh")
	private String hinhAnh;	
	
	@OneToOne
	@JoinColumn(name = "iconCamXuc")
	private ThaCamXuc thaCamXuc;
}
