<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>devises</title>
</head>
<body>
   <h3> liste des devises</h3>
   <table border="1">
   <tr><th>code</th><th>nom</th><th>change</th></tr>
   <s:iterator value="listeDevises"> 
     <tr>
       <td><s:property value="code" /></td>
       <td><s:property value="nom" /> </td>
       <td><s:property value="change" /> </td>
    </tr>
    </s:iterator>
  </table>
      <hr/>
     <s:url var="welcome_url" action="welcome"></s:url>
     <s:a href="%{welcome_url}" >retour accueil</s:a> <br/>
</body>
</html>