package tp.web.actions;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import tp.entity.Utilisateur;

public class LoginAction extends ActionSupport implements SessionAware {
	
	private SessionMap<String,Object> sessionMap;
	private Utilisateur utilisateur = new Utilisateur();

	@Override
	public void setSession(Map<String, Object> session) {
		sessionMap = (SessionMap<String,Object> ) session;
	}
	
	
	public String login() {
		System.out.println("login, utilisateur="+utilisateur);
		//utilsateur.username et utilisateur.password 
		//initialisés par struts 2 selon valeurs saisies
		//simulation d'un test de password:
		//tester en tp si la valeur du password est = à "pwd" + username
		//ok si username="user1" et si password="pwduser1"
		if( utilisateur.getPassword() != null &&
			utilisateur.getPassword().equals("pwd"+utilisateur.getUsername())) {
			sessionMap.put("username", utilisateur.getUsername());
			return "success";
		}else {
			return "input";
		}
		
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	

}
