package tp.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import tp.dao.DeviseDao;
import tp.entity.Devise;

@Component //pour demander à ce que cette classe soit d'abord prise en charge par Spring
           //avant d'être réutilisée par Struts2
@Scope("prototype") //pour new à chaque besoin de Struts2 (inverse du singleton)
public class DeviseAction extends ActionSupport {
	
	private Devise devise; //à saisir , à afficher (avec sous parties .code .nom .change)
	private List<Devise> listeDevises; // à afficher dans un tableau
	
	@Autowired //pour reférencer un composant de Spring compatible avec l'interface
	private DeviseDao deviseDao; //référence vers le Dao auquel on va déléguer certaines operations
	
	public DeviseAction(){
		super();
		devise=new Devise();
		//deviseDao=DeviseDaoSimu.getInstance();//new DeviseDaoSimu();  //ou bien new DeviseDaoHibernate() 
		
		/*
		//Code utile seulement dans le cas ou classe d'action de Struts n'est pas
		//  prise en charge par spring (cad sans @Component , @Autowired , ...)
		ServletContext servletContext = (ServletContext) 
				ActionContext.getContext().get(ServletActionContext.SERVLET_CONTEXT);
		WebApplicationContext ctxSpring =
				WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.deviseDao =  ctxSpring.getBean(DeviseDao.class);
		
		//List<Devise> devises = deviseDao.findAllDevise();
		//System.out.println("devises:"+devises);
		*/
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
