<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome</title>
</head>
<body>
   <h1>WELCOME</h1>
   <s:url var="login_url" action="login"></s:url>
   <s:a href="%{login_url}" >login</s:a> <br/>
   
   <!--  s:url a le param�trage var="..." avec struts 2.5 
         et c'�tait id="...." avec struts 2.3  -->
   <s:url var="saisir_tva_url" action="saisir_tva"></s:url>
   <s:a href="%{saisir_tva_url}" >tva</s:a> <br/>
   
   <s:url var="saisir_emprunt_url" action="saisir_emprunt"></s:url>
   <s:a href="%{saisir_emprunt_url}" >emprunt</s:a> <br/>
   
   <s:url var="refresh_devises_url" action="refresh_devises"></s:url>
   <s:a href="%{refresh_devises_url}" >devises</s:a> <br/>
</body>
</html>