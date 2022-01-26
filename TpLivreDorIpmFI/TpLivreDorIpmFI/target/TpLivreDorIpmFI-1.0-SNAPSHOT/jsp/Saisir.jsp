<%-- 
    Document   : Saisir.jsp
    Created on : 11 janv. 2022, 15:22:15
    Author     : zixin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saisir</title>
    </head>
    <body>
        <h1>Entrez votre message</h1>
        <%
            String pseudo = request.getParameter("psd");
            if (pseudo == null)
            pseudo = "";
        %>
        <form action="ctrlSaisir"
              method="GET">
            Pseudo <input type="text" name="psd" value="<%=pseudo %>" /><br>
            Message <input type="text" name="mg" value="${param.mg}"/><br>
            
            <input type="submit" value="Enregistrer" />
        </form>
        
        <%
            String avert = (String)request.getAttribute("avert");
            
            if (avert != null)
            out.println("<div>" + avert + "</div>");

            //String erreur = (String)request.getAttribute("erreur");
            
            //if (erreur != null)
            //out.println("<div>" + erreur + "</div>");
        %>
        <div>${requestScope.erreur}</div>
        
        <a href="ctrlCentral?fct=accueil">Retour vers l'accueil</a>
    </body>
</html>
