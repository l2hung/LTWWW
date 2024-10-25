package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "NHANVIEN")
public class NhanVien {
	@Id
	@Column(name = "MANV")
	private String maNhanVien;
	@Column(name = "TENNV")
	private String tenNhanVien;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "DIACHI")
	private String diaChi;
	@Column(name = "DIENTHOAI")
	private String soDienThoai;

	@ManyToOne
	@JoinColumn(name = "MAPHONGBAN")
	private PhongBan phongBan;

	public NhanVien(String maNhanVien, String tenNhanVien, String email, String diaChi, String soDienThoai,
			PhongBan phongBan) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.email = email;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.phongBan = phongBan;
	}

	public NhanVien() {
		super();
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

}
