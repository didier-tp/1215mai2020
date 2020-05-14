package tp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import tp.entity.Devise;

//@Component
@Repository  // @Component de type Repository/DAO
//pour demander � ce que cette classe soit prise en charge par Spring
//par d�faut en un seul exemplaire (comme singleton)
//@Scope("singleton") par d�faut : appropri� pour une classe de traitement (Service, Dao, ...)
//id par d�faut du composant spring : deviseDaoJpa (nom de classe avec minuscule au debut)
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
