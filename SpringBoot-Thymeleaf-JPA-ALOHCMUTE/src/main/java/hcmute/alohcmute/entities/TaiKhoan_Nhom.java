package hcmute.alohcmute.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TaiKhoan_Nhom")
public class TaiKhoan_Nhom {

	@EmbeddedId
	private TaiKhoan_Nhom_Id id;
	
	@Column(name = "accept", columnDefinition = "bit")
	private boolean accept;
}