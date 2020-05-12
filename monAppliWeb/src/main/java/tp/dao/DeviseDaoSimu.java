package tp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tp.entity.Devise;

public class DeviseDaoSimu implements DeviseDao {
	
	private Map<String,Devise> deviseMap = new HashMap<>();
	//Design pattern "Singleton":
	private static DeviseDaoSimu uniqueInstance=null;
	public static DeviseDaoSimu getInstance() {
		if(uniqueInstance==null) {
			uniqueInstance=new DeviseDaoSimu();
		}
		return uniqueInstance;
	}
	
	
	private DeviseDaoSimu(){
		//jeux de données pour tests/simulation
		deviseMap.put("EUR", new Devise("EUR","Euro",1.0));
		deviseMap.put("USD", new Devise("USD","Dollar",1.1));
		deviseMap.put("GBP", new Devise("GBP","Livre",0.9));
		deviseMap.put("JPY", new Devise("JPY","Yen",120.0));
	}

	@Override
	public Devise findDeviseByCode(String code) {
		return deviseMap.get(code);
	}

	@Override
	public List<Devise> findAllDevise() {
		return new ArrayList<Devise>(deviseMap.values());
	}

	@Override
	public void deleteDevise(String code) {
		deviseMap.remove(code);
	}

	@Override
	public void saveOrUpdateDevise(Devise d) {
	   deviseMap.put(d.getCode(), d);
	}

}
