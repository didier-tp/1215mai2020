package tp.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tp.dao.CompteDao;
import tp.entity.Compte;

@RunWith(SpringJUnit4ClassRunner.class) //pour compréhension de @Autowired sur classe de test
@ContextConfiguration(locations={"/springContext.xml"}) //pour charger en mémoire la config spring
public class TestCompteDaoHibernate {
	
	@Autowired
	private CompteDao compteDao;
	
	@Test
	public void testAjoutCompte() {
		Compte nouveauCompte = new Compte(null,"compte qui va bien",200.0);
		compteDao.save(nouveauCompte);
		System.out.println("numero du compte ajouté:" + nouveauCompte.getNumero());
		//...
		Assert.assertNotNull(nouveauCompte.getNumero());
	}

}
