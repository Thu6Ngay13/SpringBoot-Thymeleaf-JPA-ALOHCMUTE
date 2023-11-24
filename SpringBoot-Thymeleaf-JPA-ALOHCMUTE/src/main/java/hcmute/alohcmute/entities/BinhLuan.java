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
public class BinhLuan implements Serializable {
	private static final long serialVersionUID = -1396701384501394019L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaBinhLuan")
	private int maBinhLuan;
	
	@Column(name = "NoiDungChu", columnDefinition = "nvarchar(2000)")
	private String noiDungChu;
	
	@Column(name = "NoiDungHinhAnh", columnDefinition = "nvarchar(2000)")
	private String noiDungHinhAnh;
	
	@ManyToOne
	@JoinColumn(name = "MaBaiViet")
	private BaiViet baiViet;
	
}
