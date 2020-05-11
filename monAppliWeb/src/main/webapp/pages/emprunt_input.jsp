<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>emprunt_input</title>
</head>
<body>
   <h3>calcul de mensualite emprunt</h3> 
  <s:form method="post" action="calculer_emprunt" >
      <s:textfield  name="smontant" label="smontant">
      </s:textfield>
      
       <s:textfield  name="snbmois" label="durée (nbMois)">
      </s:textfield>
      
       <s:textfield  name="staux" label="taux interet annuel(%)">
      </s:textfield>
      <s:submit value="calculer emprunt"></s:submit>
  </s:form>
</body>
</html>