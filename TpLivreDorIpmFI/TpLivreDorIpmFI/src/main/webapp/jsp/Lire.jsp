<%-- 
    Document   : Lire
    Created on : 13 janv. 2022, 14:33:13
    Author     : zixin
--%>

<%@page import="java.util.List"%>
<%@page import="miage.metier.MessageDor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Les messages</title>
    </head>
    <body>
        <h1>Liste des messages d'or</h1>
        
        <%
            //Récupère l'attribut contenant la liste des messages
            List <MessageDor> liste = (List<MessageDor>) request.getAttribute("liste_msg");
            
            //Lecture de la liste et affichage
            out.println("<table border=\"1\">");
            out.println("<tr><th>Identifiant</th><th>Pseudo</th><th>Message</th></tr>");
                      
            for (MessageDor msg : liste){
                out.println("<tr><td>" + msg.getId() + "</td>" + 
                            "<td>" + msg.getPseudo() + "</td>" +
                            "<td>" + msg.getMessage() + "</td></tr>");                                               
            }
            out.println("</table>");
        %>
        
        <a href="ctrlCentral?fct=accueil">Retour vers l'accueil</a>
    </body>
</html>
