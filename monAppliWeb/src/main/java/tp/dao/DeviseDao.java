package tp.dao;

import java.util.List;

import tp.entity.Devise;

/*
 * DAO = Data Access Object
 * objet de traitement sp�cialis� dans l'acc�s aux donn�es (souvent en base SQL)
 * avec m�thodes "CRUD" Create , Recherche , Update , Delete
 * et throws RuntimeException implicites
 */

public interface DeviseDao {
	Devise findDeviseByCode(String code);
	List<Devise> findAllDevise();
	void deleteDevise(String code);
	void saveOrUpdateDevise(Devise d);
	//...
}
