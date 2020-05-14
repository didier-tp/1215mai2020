package tp.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tp.dao.DeviseDao;
import tp.entity.Devise;
import tp.entity.Pays;

@RunWith(SpringJUnit4ClassRunner.class) //pour compréhension de @Autowired sur classe de test
@ContextConfiguration(locations={"/springContext.xml"}) //pour charger en mémoire la config spring
public class TestDeviseDaoHibernate {
	
	@Autowired //demander à injecter le composant pris en charge par Spring (@Repository ou @Component)
	           //qui est compatible avec l'interface DeviseDao (implements ...)
	private DeviseDao deviseDao; //chose à tester
	
	
	@Test
	public void testDeviseByCode() {
		Devise deviseE = deviseDao.findDeviseByCode("EUR");
		//deviseE est ici a l'état détaché (car dans test ou dans partie web)
		for(Pays p : deviseE.getListePays()) {
			System.out.println("\t"+p);
		}
	}
	
	@Test
	public void testFindAllDevises() {
		List<Devise> listeDevises = deviseDao.findAllDevise();
		Assert.assertNotNull(listeDevises);
		Assert.assertTrue(listeDevises.size()>=2);
		//System.out.println("listeDevises="+listeDevises);
		for(Devise d : listeDevises) {
			System.out.println(d);
			/*for(Pays p : d.getListePays()) {
				System.out.println("\t"+p);
			}*/
		}
	}
	
	//@Test
	public void testCrudDevise() {
		Devise d = new Devise("m1","monnaie1",1.1);
		deviseDao.saveOrUpdateDevise(d);
		Devise dRelu = deviseDao.findDeviseByCode("m1");
		Assert.assertNotNull(dRelu);
		Assert.assertEquals("monnaie1", dRelu.getNom());
	    System.out.println("dRelu="+dRelu);
	    /*
	    deviseDao.deleteDevise("m1");
	    Devise dSupprimee = deviseDao.findDeviseByCode("m1");
	    Assert.assertNull(dSupprimee);
	    */
	}

}
