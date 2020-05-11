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
   <!--  s:url a le paramétrage var="..." avec struts 2.5 
         et c'était id="...." avec struts 2.3  -->
   <s:url var="saisir_tva_url" action="saisir_tva"></s:url>
   <s:a href="%{saisir_tva_url}" >tva</s:a> <br/>
</body>
</html>