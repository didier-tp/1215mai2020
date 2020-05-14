package tp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import tp.entity.Devise;

@Component
public class DeviseDaoJpa implements DeviseDao {
	
	private EntityManager entityManager;
	

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

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
		try {
			entityManager.getTransaction().begin();
				Devise dExistante= entityManager.find(Devise.class, d.getCode());
				if(dExistante==null) {
					entityManager.persist(d);
				}else {
					entityManager.merge(d);
				}
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}

	}

}
