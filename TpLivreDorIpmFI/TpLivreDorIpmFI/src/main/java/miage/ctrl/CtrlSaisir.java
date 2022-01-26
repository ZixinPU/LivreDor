/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package miage.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import miage.bd.MessageBD;
import miage.metier.MessageDor;

/**
 *
 * @author zixin
 */
public class CtrlSaisir extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pseudo = request.getParameter("psd");
        String message = request.getParameter("mg");
        
        //Tester des paramètres 
        String msg_avert = "";
        if (pseudo.isEmpty())
            msg_avert = "Veuillez saisir un pseudo !";
        
        if (message.isEmpty())
            msg_avert = "Veuillez saisir un message !"; 
        
        if (!msg_avert.isEmpty()){
            //KO - chainage vers la page saisir avec le message
            RequestDispatcher rd = request.getRequestDispatcher("saisir");
            request.setAttribute("avert", msg_avert);
            rd.forward(request, response);
        } else {
            //Créer le message d'or
            //Enregistrer 
            //Redirection
            MessageDor or = new MessageDor (pseudo,message);
            
            try{
                //Enregistrement du message
                MessageBD.enregistrerMessage(or);
                
                //Redirection
                response.sendRedirect("ctrlCentral?fct=lire");
                
            } catch (Exception ex){
                //Erreur
                RequestDispatcher rd = request.getRequestDispatcher("saisir");
                request.setAttribute("erreur", ex.getMessage());
                rd.forward(request, response);              
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
