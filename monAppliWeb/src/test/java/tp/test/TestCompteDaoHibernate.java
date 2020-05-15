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

@RunWith(SpringJUnit4ClassRunner.class) //pour compréhension de @Autowired sur classe de test
@ContextConfiguration(locations={"/springContext.xml"}) //pour charger en mémoire la config spring
public class TestCompteDaoHibernate {
	
	@Autowired
	private CompteDao compteDao; //à tester
	
	
	@Autowired
	private ClientDao clientDao; //pour tester lien entre compte et client
	
	@Test
	public void testAjoutCompte() {
		Compte nouveauCompte = new Compte(null,"compte qui va bien",200.0);
		compteDao.save(nouveauCompte);
		Assert.assertNotNull(nouveauCompte.getNumero());
		System.out.println("numero du compte ajouté:" + nouveauCompte.getNumero());
		
		
		Client nouveauClient = new Client(null,"client qui va bien");
		clientDao.save(nouveauClient);
		System.out.println("numero du client ajouté:" + nouveauClient.getNumero());
		nouveauClient.addCompte(nouveauCompte);
		clientDao.save(nouveauClient); //ok car client=coté principal (@JoinTable)
		
		List<Compte> comptesDuNouveauClient = compteDao.findComptesOfClient(nouveauClient.getNumero());
		System.out.println("comptes du nouveau client :" + comptesDuNouveauClient);
	
		/* NB:
		nouveauCompte.addClient(nouveauClient);
		compteDao.save(nouveauCompte);
		NE FONCTIONNE PAS car compte=coté secondaire mappedBy*/
	
	}
	
	@Test
	public void testComptesDuClient() {
		List<Compte> comptesDuClient1 = compteDao.findComptesOfClient(1L);
		System.out.println("comptes du client 1:" + comptesDuClient1);
		//...
		Assert.assertNotNull(comptesDuClient1);
	}

}
