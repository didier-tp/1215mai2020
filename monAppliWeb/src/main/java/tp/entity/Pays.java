package tp.entity;

public class Pays {
	
   private String code; //"fr" , "es" , ...
   private String nom; //France , espagne
   private Integer superficie;
   
          //fk =codeDevise
   private Devise devise;

@Override
public String toString() {
	return "Pays [code=" + code + ", nom=" + nom + ", superficie=" + superficie + "]";
}


   
   
}
