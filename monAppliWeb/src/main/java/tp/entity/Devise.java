package tp.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*
 * classe Devise = structure de données stockée en base en fin de semaine
 * entité persistante .
 */

@Entity
public class Devise {
	@Id
	@Column(length = 24)
	private String code; //ex: "EUR" , "USD" , ...
	
	private String nom ; //ex: "euro" , "dollar" , ...
	
	@Column(name = "eChange")
	private Double change; //nb unité pour 1 euro
	
	@OneToMany(mappedBy = "..." , fetch = FetchType.EAGER) //fetch = FetchType.EAGER temporaire
	private List<Pays> listePays; //avec get/set
	
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

	public List<Pays> getListePays() {
		return listePays;
	}

	public void setListePays(List<Pays> listePays) {
		this.listePays = listePays;
	}
	
	

}
