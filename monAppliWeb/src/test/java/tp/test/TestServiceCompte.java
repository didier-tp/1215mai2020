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
	public void testCompte() {
		Compte c = serviceCompte.rechercherCompte(1L);
		System.out.println("compte :" + c);
		//...
		Assert.assertNotNull(c);
	}

}
