package tp.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.entity.Devise;
import tp.entity.Pays;

//@Component
@Repository // @Component de type Repository/DAO
//pour demander à ce que cette classe soit prise en charge par Spring
//par défaut en un seul exemplaire (comme singleton)
//@Scope("singleton") par défaut : approprié pour une classe de traitement (Service, Dao, ...)
//id par défaut du composant spring : deviseDaoJpa (nom de classe avec minuscule au debut)
@Transactional // pour demander à Spring de gérer commit/rollback
public class DeviseDaoJpa implements DeviseDao {

	@PersistenceContext() //pour demander à Spring d'initialiser le entityManager
	//via META-INF/persistence.xml  , EntityManagerFactory , ...
	private EntityManager entityManager;

	public static void loadLazyCollection(Collection col) {
		for(Object o : col) {
			//en mode LAZY , les objets o de la collection col associés à l'objet principal
			//sont remontés en mémoire for de la boucle for
		}
		//ou bien col.size();
	}
	

	@Override
	public Devise findDeviseByCode(String code) {
		Devise d = null;
		d = entityManager.find(Devise.class, code);
		//d est ici à l'état persistant
		loadLazyCollection(d.getListePays());
		/*
		for(Pays p :d.getListePays()) {
			//en mode LAZY , les pays associés à la devise d 
			//sont remontés en mémoire for de la boucle for
		}*/
		return d;
	}

	@Override
	public List<Devise> findAllDevise() {
		String reqJPQL = "SELECT DISTINCT d FROM Devise d INNER JOIN FETCH d.listePays p ";
		return entityManager.createQuery(reqJPQL, Devise.class).getResultList();
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
