package tp.web.actions;

import com.opensymphony.xwork2.ActionSupport;

public class EmpruntAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String smontant; //à saisir
	private String staux; //à saisir
	private String snbmois; //à saisir
	private Double mensualite;//à calculer et afficher
	
	public String calculerMensualite() {
		//...
		try { 
			double montant = Double.parseDouble(smontant); //ex: 10000
			double taux = Double.parseDouble(staux); //ex: 0.96
			int nbMois = Integer.parseInt(snbmois); //ex: 120
			double tauxMensuel = taux / 12 / 100;
			this.mensualite =  montant * tauxMensuel / ( 1 - Math.pow(1+tauxMensuel,-nbMois));
			//ex: 87,4306268211912 s
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "input"; //redemander à mieux saisir
		}
	}

	public String getSmontant() {
		return smontant;
	}

	public void setSmontant(String smontant) {
		this.smontant = smontant;
	}

	public String getStaux() {
		return staux;
	}

	public void setStaux(String staux) {
		this.staux = staux;
	}

	public String getSnbmois() {
		return snbmois;
	}

	public void setSnbmois(String snbmois) {
		this.snbmois = snbmois;
	}

	public Double getMensualite() {
		return mensualite;
	}

	public void setMensualite(Double mensualite) {
		this.mensualite = mensualite;
	}
	
	
	
	

}
