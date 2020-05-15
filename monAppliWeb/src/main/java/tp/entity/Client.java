package tp.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Client {
	
	@Id
	private Long numero;
	private String nom; 
	
	@ManyToMany
	@JoinTable(name = "Client_Compte",
			joinColumns = {@JoinColumn(name = "numClient")},
			inverseJoinColumns = {@JoinColumn(name = "numCompte")})
	private List<Compte> comptes;
	

	@Override
	public String toString() {
		return "Client [numero=" + numero + ", nom=" + nom + "]";
	}

	public Client() {
		super();
	}

	public Client(Long numero, String nom, List<Compte> comptes) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.comptes = comptes;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
	
	
	
}
