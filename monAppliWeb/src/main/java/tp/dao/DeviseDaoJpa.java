package tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.entity.Devise;

//@Component
@Repository // @Component de type Repository/DAO
//pour demander � ce que cette classe soit prise en charge par Spring
//par d�faut en un seul exemplaire (comme singleton)
//@Scope("singleton") par d�faut : appropri� pour une classe de traitement (Service, Dao, ...)
//id par d�faut du composant spring : deviseDaoJpa (nom de classe avec minuscule au debut)
@Transactional // pour demander � Spring de g�rer commit/rollback
public class DeviseDaoJpa implements DeviseDao {

	@PersistenceContext() //pour demander � Spring d'initialiser le entityManager
	//via META-INF/persistence.xml  , EntityManagerFactory , ...
	private EntityManager entityManager;


	@Override
	public Devise findDeviseByCode(String code) {
		Devise d = null;
		d = entityManager.find(Devise.class, code);
		return d;
	}

	@Override
	public List<Devise> findAllDevise() {
		return entityManager.createQuery("SELECT d FROM Devise d ", Devise.class).getResultList();
	}

	@Override
	public void deleteDevise(String code) {
		Devise d = entityManager.find(Devise.class, code);
		entityManager.remove(d);
		entityManager.getTransaction().commit();
	}

	@Override
	public void saveOrUpdateDevise(Devise d) {
		Devise dExistante = entityManager.find(Devise.class, d.getCode());
		if (dExistante == null) {
			entityManager.persist(d);
		} else {
			entityManager.merge(d);
		}
	}

}
