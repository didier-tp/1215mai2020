package tp.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tp.dao.DeviseDao;
import tp.dao.DeviseDaoJdbc;
import tp.entity.Devise;

public class TestDeviseDao {
	
	private DeviseDao deviseDao;
	
	@Before
	public void initDao() {
		deviseDao= DeviseDaoJdbc.getInstance();
	}
	
	@Test
	public void testFindAllDevises() {
		List<Devise> listeDevises = deviseDao.findAllDevise();
		Assert.assertNotNull(listeDevises);
		Assert.assertTrue(listeDevises.size()>=2);
		System.out.println("listeDevises="+listeDevises);
	}

}
