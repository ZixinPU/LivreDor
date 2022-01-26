<%-- 
    Document   : Supprimer
    Created on : 14 janv. 2022, 09:40:09
    Author     : zixin
--%>

<%@page import="java.util.List"%>
<%@page import="miage.metier.MessageDor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Supprimer les messages</title>
    </head>
    <body>
        <h1>Sélection du ou des message(s) à supprimer</h1>
        
        <%
            String[] tab = request.getParameterValues("cb");
        %>
        
        <form action="ctrlConfirmer"
              method="GET">
        <%
            //Récupère l'attribut contenant la liste des messages
            List <MessageDor> liste = (List<MessageDor>) request.getAttribute("liste_msg");
            
            //Lecture de la liste et affichage
            out.println("<table border=\"1\">");
            out.println("<tr><th>Choisir</th><th>Identifiant</th><th>Pseudo</th><th>Message</th></tr>");
                      
            for (MessageDor msg : liste){
                out.println("<tr><td><input type='checkbox' name=\"cb\" value="+ msg.getId() +" /></td>" + 
                            "<td>" + msg.getId() + "</td>" + 
                            "<td>" + msg.getPseudo() + "</td>" +
                            "<td>" + msg.getMessage() + "</td></tr>");                                               
            }
            out.println("</table><br>");
        %>
        
              <input type="submit" value="Supprimer" /><br>
        </form>
        
        <%
            String avert = (String)request.getAttribute("avert");
            
            if (avert != null)
            out.println("<div>" + avert + "</div>");

            String erreur = (String)request.getAttribute("erreur");
            
            if (erreur != null)
            out.println("<div>" + erreur + "</div>");
        %>
        
        <a href="ctrlCentral?fct=accueil">Retour vers l'accueil</a>
        
    </body>
</html>
