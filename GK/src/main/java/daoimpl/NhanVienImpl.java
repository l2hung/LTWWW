package daoimpl;

import java.util.List;

import dao.NhanVienDao;
import entities.NhanVien;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;

public class NhanVienImpl implements NhanVienDao {
	private EntityManager em;

	public NhanVienImpl() {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}

	@Override
	public List<NhanVien> getAllNhanVien() {
		// TODO Auto-generated method stub
		return em.createQuery("select nv from NhanVien nv", NhanVien.class).getResultList();
	}

	@Override
	public NhanVien addNhanVien(NhanVien nhanVien) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(nhanVien);
			tx.commit();
			return nhanVien;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void deleteNhanVien(String maNhanVien) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			NhanVien nv = em.find(NhanVien.class, maNhanVien);
			em.remove(nv);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
