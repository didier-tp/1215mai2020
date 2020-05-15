package tp.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.entity.Client;
import tp.entity.Compte;

@Repository
@Transactional
public class CompteDaoJpa implements CompteDao {
	
	@PersistenceContext()
	private EntityManager entityManager;

	@Override
	public Compte save(Compte c) {
		if(c.getNumero()==null)
			entityManager.persist(c); //avec auto_increment
		else
			entityManager.merge(c);
		return c; //avec .numero not null
	}

	@Override
	public Compte findById(Long numero) {
		return entityManager.find(Compte.class,numero);
	}

	@Override
	public void delete(Long numero) {
		Compte c = entityManager.find(Compte.class,numero);
		entityManager.remove(c);
	}

	@Override
	public List<Compte> findAll() {
		return entityManager.
				createNamedQuery("Compte.findAll",Compte.class)
				.getResultList();
	}
	
	public static void loadLazyCollection(Collection col) {
		for(Object o : col) {
			//en mode LAZY , les objets o de la collection col associés à l'objet principal
			//sont remontés en mémoire for de la boucle for
		}
		//ou bien col.size();
	}

	@Override
	public List<Compte> findComptesOfClient(Long numClient) {
		/*
		// Solution 1:
		Client cli = entityManager.find(Client.class,numClient);
		loadLazyCollection(cli.getComptes());
		return cli.getComptes();
		*/
		//Solution 2:
		String reqJpaQL="SELECT cpt FROM Client cli JOIN cli.comptes cpt WHERE cli.numero= :numClient";
		return entityManager.createQuery(reqJpaQL,Compte.class)
				.setParameter("numClient", numClient)
				.getResultList();
	}

}
