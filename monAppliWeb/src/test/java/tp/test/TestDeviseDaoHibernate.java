package tp.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tp.dao.DeviseDao;
import tp.dao.DeviseDaoJpa;
import tp.dao.MyJpaUtil;
import tp.entity.Devise;

public class TestDeviseDaoHibernate {
	
	private DeviseDaoJpa deviseDao;
	
	@Before
	public void initDao() {
		deviseDao= new DeviseDaoJpa();
		EntityManagerFactory emf = MyJpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		deviseDao.setEntityManager(em);
	}
	
	@Test
	public void testFindAllDevises() {
		List<Devise> listeDevises = deviseDao.findAllDevise();
		Assert.assertNotNull(listeDevises);
		Assert.assertTrue(listeDevises.size()>=2);
		System.out.println("listeDevises="+listeDevises);
	}
	
	@Test
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
