package tp.service;

import tp.entity.Compte;

public interface ServiceCompte {
	public Compte rechercherCompte(Long numero);
	//...
	public void transferer(Double montant,Long numCptDeb , Long numCptCred);
}
