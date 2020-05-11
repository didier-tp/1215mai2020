<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>emprunt_result</title>
</head>
<body>
    montant: <s:property value="smontant" /> <br/>
    taux interet annuel: <s:property value="staux" /> <br/>
    duree (nbMois): <s:property value="snbmois" /> <br/>
    mensualite: <s:property value="mensualite" /> <br/>
    <hr/>
     <s:url var="saisir_emprunt_url" action="saisir_emprunt"></s:url>
     <s:a href="%{saisir_emprunt_url}" >autre calcul emprunt</s:a> <br/>
      <hr/>
     <s:url var="welcome_url" action="welcome"></s:url>
     <s:a href="%{welcome_url}" >retour accueil</s:a> <br/>
</body>
</html>