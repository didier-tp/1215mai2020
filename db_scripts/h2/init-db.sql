DROP TABLE IF EXISTS Pays;
DROP TABLE IF EXISTS Devise;

CREATE TABLE  Devise(
   code VARCHAR(24) primary key,
   nom VARCHAR(64),
   eChange double
);

CREATE TABLE  Pays(
   code VARCHAR(24) primary key,
   nom VARCHAR(64),
   superficie integer,
   codeDevise VARCHAR(24) ,
   CONSTRAINT Pays_avec_devise_valide FOREIGN KEY (codeDevise) REFERENCES Devise(code)
);

INSERT INTO Devise(code,nom,eChange) VALUES('EUR','Euro',1);
INSERT INTO Devise(code,nom,eChange) VALUES('USD','Dollar',1.11);
INSERT INTO Devise(code,nom,eChange) VALUES('GBP','Livre',0.91);
INSERT INTO Devise(code,nom,eChange) VALUES('JPY','Yen',124.24);

INSERT INTO Pays(code,nom,superficie,codeDevise) 
           VALUES('fr','France',1,'EUR');
INSERT INTO Pays(code,nom,superficie,codeDevise) 
           VALUES('es','Espagne',1,'EUR');	
INSERT INTO Pays(code,nom,superficie,codeDevise) 
           VALUES('usa','Etats Unis',2,'USD');			   


SELECT * FROM Devise;
SELECT * FROM Pays;