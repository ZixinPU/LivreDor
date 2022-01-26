<%-- 
    Document   : Confirmer
    Created on : 14 janv. 2022, 10:01:15
    Author     : zixin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confimer la suppression</title>
    </head>
    <body>
        <h1>Souhaitez-vous supprimer ces messages ?</h1>
        
        <%
	    String[] tabIds = (String[])session.getAttribute("tabIds");
            for(int i=0; i<tabIds.length-1; i++){
                out.println(tabIds[i] + ", ");                           
            }	    
            out.println(tabIds[tabIds.length-1]);
	%>
	<div>${sessionScope.TabIds}</div>
               
        <a href = "ctrlSupprimer">Oui</a> 
        <a href = "ctrlCentral?fct=suppr">Non</a><br>
        <a href = "ctrlCentral?fct=accueil">Annuler</a>
        
</html>
