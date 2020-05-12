package tp.entity;

/*
 * classe Devise = structure de données stockée en base en fin de semaine
 * entité persistante .
 */

public class Devise {
	private String code; //ex: "EUR" , "USD" , ...
	private String nom ; //ex: "euro" , "dollar" , ...
	private Double change; //nb unité pour 1 euro
	
	
	@Override
	public String toString() {
		return "Devise [code=" + code + ", nom=" + nom + ", change=" + change + "]";
	}

	public Devise() {
		super();
	}
	
	public Devise(String code, String nom, Double change) {
		super();
		this.code = code;
		this.nom = nom;
		this.change = change;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Double getChange() {
		return change;
	}
	public void setChange(Double change) {
		this.change = change;
	}
	
	

}
