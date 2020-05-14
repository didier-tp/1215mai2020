package tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

}
