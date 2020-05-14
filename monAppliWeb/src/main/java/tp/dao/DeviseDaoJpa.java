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
//pour demander � ce que cette classe soit prise en charge par Spring
//par d�faut en un seul exemplaire (comme singleton)
//@Scope("singleton") par d�faut : appropri� pour une classe de traitement (Service, Dao, ...)
//id par d�faut du composant spring : deviseDaoJpa (nom de classe avec minuscule au debut)
@Transactional // pour demander � Spring de g�rer commit/rollback
public class DeviseDaoJpa implements DeviseDao {

	@PersistenceContext() //pour demander � Spring d'initialiser le entityManager
	//via META-INF/persistence.xml  , EntityManagerFactory , ...
	private EntityManager entityManager;

	public static void loadLazyCollection(Collection col) {
		for(Object o : col) {
			//en mode LAZY , les objets o de la collection col associ�s � l'objet principal
			//sont remont�s en m�moire for de la boucle for
		}
		//ou bien col.size();
	}
	

	@Override
	public Devise findDeviseByCode(String code) {
		Devise d = null;
		d = entityManager.find(Devise.class, code);
		//d est ici � l'�tat persistant
		loadLazyCollection(d.getListePays());
		/*
		for(Pays p :d.getListePays()) {
			//en mode LAZY , les pays associ�s � la devise d 
			//sont remont�s en m�moire for de la boucle for
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
