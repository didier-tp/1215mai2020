<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<style type="text/css">@import url(../css/styles.css);</style>
</head>
<body>
   <h3>login</h3> 
  <s:form method="post" action="login" >
      <s:textfield  name="utilisateur.username" label="username">
      </s:textfield>
      
       <s:textfield  name="utilisateur.password" label="password">
      </s:textfield>
      
      <s:radio name="utilisateur.role" label="role"
              list="{'admin','user','manager','hacker'}" /> 
       <!--         
	   <s:select name="utilisateur.role" list="{'admin','user','manager','hacker'}"
		headerKey="" 
		label="Select a role" /> -->

	   <s:checkbox name="utilisateur.fou"  label="fou" />

      <s:submit value="login"></s:submit>
  </s:form>
</body>
</html>