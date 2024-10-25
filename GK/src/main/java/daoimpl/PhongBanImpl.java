package daoimpl;

import java.util.List;

import dao.PhongBanDao;
import entities.PhongBan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PhongBanImpl implements PhongBanDao {
	private EntityManager em;

	public PhongBanImpl() {
		em = Persistence.createEntityManagerFactory("MSSQL").createEntityManager();
	}

	@Override
	public List<PhongBan> getAllPhongBan() {
		// TODO Auto-generated method stub
		return em.createQuery("select pb from PhongBan pb", PhongBan.class).getResultList();
	}

	@Override
	public PhongBan findPhongBanById(String maPhongBan) {
		return em.createQuery("select pb from PhongBan pb where pb.maPhongBan = :maPhongBan", PhongBan.class)
				.setParameter("maPhongBan", maPhongBan).getSingleResult();
	}
	
}
