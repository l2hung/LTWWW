package dao;

import java.util.List;

import entities.PhongBan;

public interface PhongBanDao {
	public List<PhongBan> getAllPhongBan();
	public PhongBan findPhongBanById(String maPhongBan);
}
