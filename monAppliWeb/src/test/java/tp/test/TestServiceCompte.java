package tp.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tp.entity.Compte;
import tp.service.ServiceCompte;

@RunWith(SpringJUnit4ClassRunner.class) //pour compréhension de @Autowired sur classe de test
@ContextConfiguration(locations={"/springContext.xml"}) //pour charger en mémoire la config spring
public class TestServiceCompte {
	
	@Autowired
	private ServiceCompte serviceCompte;
	
	@Test
	public void testBonTransfert() {
		Compte cptDebAvant = serviceCompte.rechercherCompte(1L);
		System.out.println("cptDebAvant :" + cptDebAvant);
		Compte cptCredAvant = serviceCompte.rechercherCompte(2L);
		System.out.println("cptCredAvant :" + cptCredAvant);
		serviceCompte.transferer(50.0, 1L, 2L);
		Compte cptDebApres = serviceCompte.rechercherCompte(1L);
		System.out.println("cptDebApres :" + cptDebApres);
		Compte cptCredApres = serviceCompte.rechercherCompte(2L);
		System.out.println("cptCredApres :" + cptCredApres);
		Assert.assertEquals(cptDebAvant.getSolde()-50,cptDebApres.getSolde(),0.0001);
		Assert.assertEquals(cptCredAvant.getSolde()+50,cptCredApres.getSolde(),0.0001);
	}
	
	@Test
	public void testMauvaisTransfert() {
		Compte cptDebAvant = serviceCompte.rechercherCompte(1L);
		System.out.println("cptDebAvant :" + cptDebAvant);
		Compte cptCredAvant = serviceCompte.rechercherCompte(2L);
		System.out.println("cptCredAvant :" + cptCredAvant);
		try {
			serviceCompte.transferer(50.0, 1L, -2L);//-2 n'existe pas
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println(e.getMessage());
		}
		Compte cptDebApres = serviceCompte.rechercherCompte(1L);
		System.out.println("cptDebApres :" + cptDebApres);
		Compte cptCredApres = serviceCompte.rechercherCompte(2L);
		System.out.println("cptCredApres :" + cptCredApres);
		Assert.assertEquals(cptDebAvant.getSolde(),cptDebApres.getSolde(),0.0001);
		Assert.assertEquals(cptCredAvant.getSolde(),cptCredApres.getSolde(),0.0001);
	}
	
	
	@Test
	public void testCompte() {
		Compte c = serviceCompte.rechercherCompte(1L);
		System.out.println("compte :" + c);
		//...
		Assert.assertNotNull(c);
	}

}
