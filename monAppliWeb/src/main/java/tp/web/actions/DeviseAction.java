package tp.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import tp.dao.DeviseDao;
import tp.dao.DeviseDaoSimu;
import tp.entity.Devise;

public class DeviseAction extends ActionSupport {
	
	private Devise devise; //à saisir , à afficher (avec sous parties .code .nom .change)
	private List<Devise> listeDevises; // à afficher dans un tableau
	
	private DeviseDao deviseDao; //référence vers le Dao auquel on va déléguer certaines operations
	
	public DeviseAction(){
		super();
		devise=new Devise();
		deviseDao=DeviseDaoSimu.getInstance();//new DeviseDaoSimu();  //ou bien new DeviseDaoHibernate() 
	}
	
	public String supprimerDevise() {
		HttpServletRequest request = (HttpServletRequest)
				ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
		String codeDeviseAsupprimer = request.getParameter("code");
		System.out.println("codeDeviseAsupprimer="+codeDeviseAsupprimer
				          + " deviseAction="+this.toString());
		deviseDao.deleteDevise(codeDeviseAsupprimer);
		return "success";
	}
	
	
	public String ajouterOuMajDevise() {
		deviseDao.saveOrUpdateDevise(this.devise);
		return "success";
	}
	
	public String selectionnerDevise() {
		HttpServletRequest request = (HttpServletRequest)
				ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
		String codeDeviseSelectionnee = request.getParameter("code");
		this.devise = deviseDao.findDeviseByCode(codeDeviseSelectionnee);
		return "success";
	}
	
	public String rafraichirListeDevise() {
		this.listeDevises = deviseDao.findAllDevise();
		System.out.println("rafraichirListeDevise appelé sur deviseAction="+this.toString());
		return "success";
	}
	
	

	public Devise getDevise() {
		return devise;
	}

	public void setDevise(Devise devise) {
		this.devise = devise;
	}

	public List<Devise> getListeDevises() {
		return listeDevises;
	}

	public void setListeDevises(List<Devise> listeDevises) {
		this.listeDevises = listeDevises;
	}
	
	

}
