package tp.web.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import tp.dao.DeviseDao;
import tp.dao.DeviseDaoSimu;
import tp.entity.Devise;

public class DeviseAction extends ActionSupport {
	
	private Devise devise; //� saisir , � afficher (avec sous parties .code .nom .change)
	private List<Devise> listeDevises; // � affciher dans un tableau
	
	private DeviseDao deviseDao; //r�f�rence vers le Dao auquel on va d�l�guer certaines operations
	
	public DeviseAction(){
		super();
		deviseDao=new DeviseDaoSimu();  //ou bien new DeviseDaoHibernate() 
	}

}
