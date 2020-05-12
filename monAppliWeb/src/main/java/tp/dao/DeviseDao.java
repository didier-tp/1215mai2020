package tp.dao;

import java.util.List;

import tp.entity.Devise;

/*
 * DAO = Data Access Object
 * objet de traitement spécialisé dans l'accès aux données (souvent en base SQL)
 * avec méthodes "CRUD" Create , Recherche , Update , Delete
 * et throws RuntimeException implicites
 */

public interface DeviseDao {
	Devise findDeviseByCode(String code);
	List<Devise> findAllDevise();
	void deleteDevise(String code);
	void saveOrUpdateDevise(Devise d);
	//...
}
