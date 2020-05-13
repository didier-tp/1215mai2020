package tp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pays {
	
   @Id
   private String code; //"fr" , "es" , ...
   private String nom; //France , espagne
   private Integer superficie;
   
   @ManyToOne()
    @JoinColumn(name="codeDevise")      //fk =codeDevise
   private Devise devise;

@Override
public String toString() {
	return "Pays [code=" + code + ", nom=" + nom + ", superficie=" + superficie + "]";
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

public Integer getSuperficie() {
	return superficie;
}

public void setSuperficie(Integer superficie) {
	this.superficie = superficie;
}

public Devise getDevise() {
	return devise;
}

public void setDevise(Devise devise) {
	this.devise = devise;
}


   
   
}
