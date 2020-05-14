package tp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Compte {
	
	//@GeneratedValue avec IDENTITY permet de demander que l' auto incrémentation 
	//de la clef primaire (lors du .persist() /  INSERT_INTO)
	//remonte bien en mémoire en java dans l'objet Compte
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY : ok pour H2,Mysql,PostgreSQL
	private Long numero;
	
	private String label;
	
	private Double solde;
	//...
	
	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", label=" + label + ", solde=" + solde + "]";
	}
	
	public Long getNumero() {
		return numero;
	}
	
	
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	
	
}
