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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/springContext.xml"})
public class TestDeviseDaoHibernate {
	
	@Autowired
	private DeviseDao deviseDao; //chose � tester
	
	
	@Test
	public void testFindAllDevises() {
		List<Devise> listeDevises = deviseDao.findAllDevise();
		Assert.assertNotNull(listeDevises);
		Assert.assertTrue(listeDevises.size()>=2);
		//System.out.println("listeDevises="+listeDevises);
		for(Devise d : listeDevises) {
			System.out.println(d);
			for(Pays p : d.getListePays()) {
				System.out.println("\t"+p);
			}
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
