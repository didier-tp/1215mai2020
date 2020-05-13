package tp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * classe Devise = structure de donn�es stock�e en base en fin de semaine
 * entit� persistante .
 */

@Entity
public class Devise {
	@Id
	@Column(length = 24)
	private String code; //ex: "EUR" , "USD" , ...
	
	private String nom ; //ex: "euro" , "dollar" , ...
	
	@Column(name = "eChange")
	private Double change; //nb unit� pour 1 euro
	
	
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
