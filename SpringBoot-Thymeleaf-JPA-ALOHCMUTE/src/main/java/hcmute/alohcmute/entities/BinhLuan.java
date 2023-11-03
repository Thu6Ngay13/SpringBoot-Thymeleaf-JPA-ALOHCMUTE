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
@NamedQuery(name="BinhLuan.findAll", query="SELECT bl FROM BinhLuan bl")
public class BinhLuan implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaBinhLuan")
	private int maBinhLuan;
	
	@Column(name = "NoiDungChu")
	private String noiDungChu;
	
	@Column(name = "NoiDungHinhAnh")
	private String noiDungHinhAnh;
	
	@ManyToOne
	@JoinColumn(name = "MaBaiViet")
	private BaiViet baiViet;
	
	@ManyToOne
	@JoinColumn(name = "MaBinhLuan")
	private BinhLuan binhLuanCha;
	
	@OneToMany(mappedBy = "binhLuanCha", fetch = FetchType.EAGER)
	private List<BinhLuan> binhLuanCons;
	
	
}
