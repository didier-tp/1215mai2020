DROP TABLE IF EXISTS Pays;
DROP TABLE IF EXISTS Devise;
DROP TABLE IF EXISTS Client_Compte;
DROP TABLE IF EXISTS Client;
DROP TABLE IF EXISTS Compte;

CREATE TABLE  Compte(
   numero integer  auto_increment primary key,
   label VARCHAR(64),
   solde double
);

CREATE TABLE  Client(
   numero integer  auto_increment primary key,
   nom VARCHAR(64)
);

CREATE TABLE  Client_Compte(
   numClient integer  ,
   numCompte integer  ,
   primary key(numClient,numCompte),
   CONSTRAINT client_valide FOREIGN KEY (numClient) REFERENCES Client(numero) ,
   CONSTRAINT compte_valide FOREIGN KEY (numCompte) REFERENCES Compte(numero)
);

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

INSERT INTO Compte(label,solde) VALUES('compte 1',100.0);
INSERT INTO Compte(label,solde) VALUES('compte 2',100.0);
INSERT INTO Compte(label,solde) VALUES('compte 3',200.0);
INSERT INTO Compte(label,solde) VALUES('compte 4',200.0);

INSERT INTO Client(nom) VALUES('toto');
INSERT INTO Client(nom) VALUES('titi');

INSERT INTO Client_Compte(numClient,numCompte) VALUES(1,1);
INSERT INTO Client_Compte(numClient,numCompte) VALUES(1,2);
INSERT INTO Client_Compte(numClient,numCompte) VALUES(2,2);
INSERT INTO Client_Compte(numClient,numCompte) VALUES(2,3);
INSERT INTO Client_Compte(numClient,numCompte) VALUES(2,4);

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
SELECT * FROM Compte;
SELECT * FROM Client;
SELECT * FROM Client_Compte;