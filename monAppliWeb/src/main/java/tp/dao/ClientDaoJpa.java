package tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tp.entity.Client;

@Repository
@Transactional
public class ClientDaoJpa implements ClientDao {
	
	@PersistenceContext()
	private EntityManager entityManager;

	@Override
	public Client save(Client c) {
		if(c.getNumero()==null)
			entityManager.persist(c); //avec auto_increment
		else
			entityManager.merge(c);
		return c; //avec .numero not null
	}

	@Override
	public Client findById(Long numero) {
		return entityManager.find(Client.class,numero);
	}

	@Override
	public void delete(Long numero) {
		Client c = entityManager.find(Client.class,numero);
		entityManager.remove(c);
	}

	@Override
	public List<Client> findAll() {
		return entityManager.
				createNamedQuery("Client.findAll",Client.class)
				.getResultList();
	}
	


}
