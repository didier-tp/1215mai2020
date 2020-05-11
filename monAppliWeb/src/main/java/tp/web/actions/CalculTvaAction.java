package tp.web.actions;

import com.opensymphony.xwork2.ActionSupport;

public class CalculTvaAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String ht; //à saisir
	private String taux; //à saisir
	private Double tva; //à calculer et afficher
	private Double ttc;
	
	public String calculer() {
		//...
		try { 
			double dHt = Double.parseDouble(ht);
			double dTaux = Double.parseDouble(taux);
			this.tva = dHt * dTaux/100;
			this.ttc = dHt + this.tva;
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "input"; //redemander à mieux saisir
		}
	}
	
	public String getHt() {
		return ht;
	}
	public void setHt(String ht) {
		this.ht = ht;
	}
	public String getTaux() {
		return taux;
	}
	public void setTaux(String taux) {
		this.taux = taux;
	}
	public Double getTva() {
		return tva;
	}
	public void setTva(Double tva) {
		this.tva = tva;
	}
	public Double getTtc() {
		return ttc;
	}
	public void setTtc(Double ttc) {
		this.ttc = ttc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	
	
	

}
