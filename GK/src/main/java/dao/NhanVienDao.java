package dao;

import java.util.List;

import entities.NhanVien;

public interface NhanVienDao {
	public List<NhanVien> getAllNhanVien();
	public NhanVien addNhanVien (NhanVien nhanVien);
	public void deleteNhanVien (String maNhanVien);
}
