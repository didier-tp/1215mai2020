<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
   <h3>login</h3> 
  <s:form method="post" action="login" >
      <s:textfield  name="utilisateur.username" label="username">
      </s:textfield>
      
       <s:textfield  name="utilisateur.password" label="password">
      </s:textfield>
      <s:submit value="login"></s:submit>
  </s:form>
</body>
</html>