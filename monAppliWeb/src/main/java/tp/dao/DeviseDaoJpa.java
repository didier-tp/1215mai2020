package tp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import tp.entity.Devise;

public class DeviseDaoJpa implements DeviseDao {
	
	private EntityManager entityManager;

	@Override
	public Devise findDeviseByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Devise> findAllDevise() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDevise(String code) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveOrUpdateDevise(Devise d) {
		// TODO Auto-generated method stub

	}

}
