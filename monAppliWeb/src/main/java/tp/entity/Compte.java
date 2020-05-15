package tp.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Compte.findAll" , query="SELECT c FROM Compte c")
public class Compte {
	
	//@GeneratedValue avec IDENTITY permet de demander que l' auto incrémentation 
	//de la clef primaire (lors du .persist() /  INSERT_INTO)
	//remonte bien en mémoire en java dans l'objet Compte
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY : ok pour H2,Mysql,PostgreSQL
	private Long numero;
	
	private String label;
	
	private Double solde;
	
	@ManyToMany(mappedBy = "comptes")
	private List<Client> clients; //+get/set
	
	public Compte() {
		super();
	}
	
	
	public Compte(Long numero, String label, Double solde) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
	}



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


	public List<Client> getClients() {
		return clients;
	}


	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	
}
