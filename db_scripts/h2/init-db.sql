DROP TABLE IF EXISTS Devise;

CREATE TABLE  Devise(
   code VARCHAR(24) primary key,
   nom VARCHAR(64),
   eChange double
);

INSERT INTO Devise(code,nom,eChange) VALUES('EUR','Euro',1);
INSERT INTO Devise(code,nom,eChange) VALUES('USD','Dollar',1.11);
INSERT INTO Devise(code,nom,eChange) VALUES('GBP','Livre',0.91);
INSERT INTO Devise(code,nom,eChange) VALUES('JPY','Yen',124.24);

SELECT * FROM Devise;