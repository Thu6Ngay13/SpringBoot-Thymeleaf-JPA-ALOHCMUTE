package hcmute.alohcmute.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor

@Entity
@Table(name="CuocHoiThoai")
public class CuocHoiThoai implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maCuocHoiThoai;
	@Column
	private String tenCuocHoiThoai;
	
	
	  @OneToMany(mappedBy="cuocHoiThoai", fetch=FetchType.EAGER) 
	  private List<TinNhan> tinNhans;
	 
	
	  @ManyToMany(mappedBy = "cuocHoiThoai") 
	  private Set<TaiKhoan> taiKhoans = new HashSet<TaiKhoan>();
	 
	

}
