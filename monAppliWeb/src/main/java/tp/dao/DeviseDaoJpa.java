package tp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import tp.entity.Devise;

public class DeviseDaoJpa implements DeviseDao {
	
	private EntityManager entityManager;
	

	@Override
	public Devise findDeviseByCode(String code) {
		Devise d =null;
		d= entityManager.find(Devise.class, code);
		return d;
	}

	@Override
	public List<Devise> findAllDevise() {
		return entityManager.createQuery("SELECT d FROM Devise d ",Devise.class)
				            .getResultList();
	}

	@Override
	public void deleteDevise(String code) {
		try {
			entityManager.getTransaction().begin();
				Devise d= entityManager.find(Devise.class, code);
				entityManager.remove(d);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void saveOrUpdateDevise(Devise d) {
		// TODO Auto-generated method stub

	}

}
