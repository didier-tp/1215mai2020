<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>tva_input</title>
</head>
<body>
   <h3>calcul de tva</h3> 
  <s:form method="post" action="calculer_tva" >
      <s:textfield  name="ht" label="ht">
      </s:textfield>
      
       <s:textfield  name="taux" label="taux tva(%)">
      </s:textfield>
      <s:submit value="calculer tva"></s:submit>
  </s:form>
</body>
</html>