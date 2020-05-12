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
   <h3> devise :</h3>
    <s:form method="post" action="ajoutOuMaj_devise" >
      <s:textfield  name="devise.code" label="code">
      </s:textfield>
      
       <s:textfield  name="devise.nom" label="nom">
      </s:textfield>
      
       <s:textfield  name="devise.change" label="change">
      </s:textfield>
      <s:submit value="ajouter ou mettre à jour"></s:submit>
  </s:form>

   <h3> liste des devises</h3>
   <table border="1">
   <tr><th>code</th><th>nom</th><th>change</th><th>suppression</th></tr>
   <s:iterator value="listeDevises"> 
     <tr>
       <td><s:property value="code" /></td>
       <td><s:property value="nom" /> </td>
       <td><s:property value="change" /> </td>
       <td> 
           <s:url var="supprimer_devise_url" action="supprimer_devise">
                <s:param name="code" value="%{code}"></s:param>
           </s:url>
           <!--  url sera à peu près s2/supprimer_devise.action?code=EUR -->
           <s:a href="%{supprimer_devise_url}" >supprimer</s:a>
       </td>
    </tr>
    </s:iterator>
  </table>
      <hr/>
     <s:url var="welcome_url" action="welcome"></s:url>
     <s:a href="%{welcome_url}" >retour accueil</s:a> <br/>
</body>
</html>