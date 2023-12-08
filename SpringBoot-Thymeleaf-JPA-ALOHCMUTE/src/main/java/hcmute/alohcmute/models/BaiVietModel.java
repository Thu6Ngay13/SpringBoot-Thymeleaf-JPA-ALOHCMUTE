package hcmute.alohcmute.models;

import java.time.LocalDate;
import java.time.LocalTime;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaiVietModel {

	private int maBaiViet;

	private String noiDungChu;

	private String noiDungHinhAnh;

	private LocalTime ThoiGian;

	private LocalDate Ngay;
	
	private long soComment;
	
	private long soTuongTac;
}
