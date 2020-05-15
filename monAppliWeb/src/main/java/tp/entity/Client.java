package tp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Client.findAll" , query="SELECT c FROM Client c")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long numero;
	private String nom; 
	
	@ManyToMany(/*fetch = FetchType.LAZY par defaut*/)
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

	public Client(Long numero, String nom) {
		super();
		this.numero = numero;
		this.nom = nom;
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
	
	public void addCompte(Compte c) {
		if(comptes==null) {
			comptes = new ArrayList<Compte>();
		}
		comptes.add(c);
	}
	
	
	
}
