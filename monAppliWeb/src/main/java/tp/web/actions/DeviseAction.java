package tp.web.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import tp.dao.DeviseDao;
import tp.dao.DeviseDaoSimu;
import tp.entity.Devise;

public class DeviseAction extends ActionSupport {
	
	private Devise devise; //à saisir , à afficher (avec sous parties .code .nom .change)
	private List<Devise> listeDevises; // à affciher dans un tableau
	
	private DeviseDao deviseDao; //référence vers le Dao auquel on va déléguer certaines operations
	
	public DeviseAction(){
		super();
		deviseDao=new DeviseDaoSimu();  //ou bien new DeviseDaoHibernate() 
	}

}
