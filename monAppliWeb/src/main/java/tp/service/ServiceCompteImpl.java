package tp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tp.dao.CompteDao;
import tp.entity.Compte;

@Service // ou @Component
@Transactional(/*propagation = Propagation.REQUIRED par defaut */)
public class ServiceCompteImpl implements ServiceCompte {
	
	@Autowired
	private CompteDao compteDao;

	@Override
	public Compte rechercherCompte(Long numero) {
		return compteDao.findById(numero);
	}

	@Override
	public void transferer(Double montant, Long numCptDeb, Long numCptCred) {
		Compte cptDeb = compteDao.findById(numCptDeb);
		cptDeb.setSolde(cptDeb.getSolde() - montant);
		//compteDao.save(cptDeb);//explicite ou implicite en mode persistant
		
		Compte cptCred = compteDao.findById(numCptCred);
		cptCred.setSolde(cptCred.getSolde() + montant);
		//compteDao.save(cptCred);
	}

}
