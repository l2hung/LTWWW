package entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PHONGBAN")
public class PhongBan {
	@Id
	@Column(name = "MAPHONGBAN")
	private String maPhongBan;
	@Column(name = "TENPHONGBAN")
	private String tenPhongBan;

	@OneToMany(mappedBy = "phongBan")
	List<NhanVien> listNhanVien;

	public PhongBan(String maPhongBan, String tenPhongBan, List<NhanVien> listNhanVien) {
		super();
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		this.listNhanVien = listNhanVien;
	}

	public PhongBan() {
		super();
	}

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	public List<NhanVien> getListNhanVien() {
		return listNhanVien;
	}

	public void setListNhanVien(List<NhanVien> listNhanVien) {
		this.listNhanVien = listNhanVien;
	}

}