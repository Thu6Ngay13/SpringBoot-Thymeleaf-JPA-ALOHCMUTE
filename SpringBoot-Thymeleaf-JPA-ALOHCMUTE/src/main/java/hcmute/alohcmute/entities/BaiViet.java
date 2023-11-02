package hcmute.alohcmute.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
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
@NamedQuery(name="BaiViet.findAll",query="select bv from BaiViet bv")
public class BaiViet implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MaBaiViet;
	
	@Column
	private String NoiDungChu;
	
	@Column
	private String NoiDungHinhAnh;
	
	@ManyToOne
	@JoinColumn(name = "MaBaxiViet")
	private ThaCamXuc ThaCamXuc;
	
	@OneToMany(mappedBy = "BaiViet", fetch = FetchType.EAGER)
	private List<BinhLuan> BinhLuans;
	
}
