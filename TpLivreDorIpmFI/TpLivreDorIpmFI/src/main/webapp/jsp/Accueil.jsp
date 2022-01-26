<%-- 
    Document   : Accueil
    Created on : 10 janv. 2022, 15:39:48
    Author     : zixin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Le livre d'or</title>
    </head>
    <body>
        <h1>Menu du livre d'or</h1>
        <ul>
            <li><a href = "ctrlCentral?fct=saisir">Saisir</a></li>
            <li><a href = "ctrlCentral?fct=lire">Lire</a></li>
            <li><a href = "ctrlCentral?fct=suppr">Supprimer</a></li>
        </ul>
        <%           
            String erreur = (String)request.getAttribute("msg_erreur");
            
            if (erreur != null)
            out.println("<div>" + erreur + "</div>");
        %>
    </body>
</html>
