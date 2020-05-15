package tp.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tp.dao.ClientDao;
import tp.dao.CompteDao;
import tp.entity.Client;
import tp.entity.Compte;

@RunWith(SpringJUnit4ClassRunner.class) //pour compr�hension de @Autowired sur classe de test
@ContextConfiguration(locations={"/springContext.xml"}) //pour charger en m�moire la config spring
public class TestCompteDaoHibernate {
	
	@Autowired
	private CompteDao compteDao; //� tester
	
	
	@Autowired
	private ClientDao clientDao; //pour tester lien entre compte et client
	
	@Test
	public void testAjoutCompte() {
		Compte nouveauCompte = new Compte(null,"compte qui va bien",200.0);
		compteDao.save(nouveauCompte);
		Assert.assertNotNull(nouveauCompte.getNumero());
		System.out.println("numero du compte ajout�:" + nouveauCompte.getNumero());
		
		
		Client nouveauClient = new Client(null,"client qui va bien");
		clientDao.save(nouveauClient);
		System.out.println("numero du client ajout�:" + nouveauClient.getNumero());
		nouveauClient.addCompte(nouveauCompte);
		clientDao.save(nouveauClient); //ok car client=cot� principal (@JoinTable)
		
		List<Compte> comptesDuNouveauClient = compteDao.findComptesOfClient(nouveauClient.getNumero());
		System.out.println("comptes du nouveau client :" + comptesDuNouveauClient);
	
		/* NB:
		nouveauCompte.addClient(nouveauClient);
		compteDao.save(nouveauCompte);
		NE FONCTIONNE PAS car compte=cot� secondaire mappedBy*/
	
	}
	
	@Test
	public void testComptesDuClient() {
		List<Compte> comptesDuClient1 = compteDao.findComptesOfClient(1L);
		System.out.println("comptes du client 1:" + comptesDuClient1);
		//...
		Assert.assertNotNull(comptesDuClient1);
	}

}
