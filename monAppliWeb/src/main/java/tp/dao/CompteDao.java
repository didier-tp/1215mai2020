package tp.dao;

import java.util.List;

import tp.entity.Compte;

public interface CompteDao {
	Compte save(Compte c);
	Compte findById(Long numero);
	List<Compte>   findComptesOfClient(Long numClient);
	void delete(Long numero);
	List<Compte> findAll();
}
