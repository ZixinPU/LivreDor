<%-- 
    Document   : Lire
    Created on : 12 janv. 2022, 18:50:53
    Author     : zixin
--%>

<%@page import="java.util.List"%>
<%@page import="miage.metier.MessageDor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lire</title>
    </head>
    <body>
        <h1>Les messages du livre d'or</h1>
                   
            <%
            List<MessageDor> liste = (List) request.getAttribute("liste");
            String erreur = (String) request.getAttribute("erreur");
            if (erreur != null) {
                out.println("<div>" + erreur + "</div>");
            } else {
                out.println("<table style = 'border: black' border = '1'><tr><th>Pseudo</th><th>Message</th></tr>");
            }
            for (MessageDor msg : liste) {
                out.println("<tr><td>" + msg.getPseudo() + "</td><td>" + msg.getMessage() + "</td></tr>");
            }
            out.println("</table>");
        %>
        
        <a href="ctrlCentral?fct=accueil">Retour vers l'accueil</a>
    </body>
</html>
