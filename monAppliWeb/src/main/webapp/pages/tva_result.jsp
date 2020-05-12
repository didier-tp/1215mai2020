<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>tva_result</title>
</head>
<body>
    username : <s:property value="#session.username" />     
    ht: <s:property value="ht" /> <br/>
    taux: <s:property value="taux" /> <br/>
    tva: <s:property value="tva" /> <br/>
    ttc: <s:property value="ttc" /> <br/>
     <hr/>
      <s:url var="saisir_tva_url" action="saisir_tva"></s:url>
      <s:a href="%{saisir_tva_url}" >autre calcul de tva</s:a> <br/>
      <hr/>
     <s:url var="welcome_url" action="welcome"></s:url>
     <s:a href="%{welcome_url}" >retour accueil</s:a> <br/>
</body>
</html>