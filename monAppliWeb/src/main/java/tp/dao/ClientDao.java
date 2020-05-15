package tp.dao;

import java.util.List;

import tp.entity.Client;

public interface ClientDao {
	Client save(Client c);
	Client findById(Long numero);
	void delete(Long numero);
	List<Client> findAll();
}
