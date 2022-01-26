/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package miage.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class CtrlCentral extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        //Récupérer le paramètre fct
        String fct = request.getParameter("fct");
        
        switch (fct){
            case "lire":
                //Lecture des messages
                try {
                    List <MessageDor> list = MessageBD.lireMessages();
                    
                    //Chainage vers lire.jsp
                    RequestDispatcher rd = request.getRequestDispatcher("lire");
                    request.setAttribute("liste_msg", list);
                    rd.forward(request, response);
                } catch (Exception e){
                    //Chainage vers le page d'accueil avec un message
                    RequestDispatcher rd = request.getRequestDispatcher("accueil");
                    request.setAttribute("msg_erreur", e.getMessage());
                    rd.forward(request, response);               
                }
                break;
            case "saisir":
                //Chainage vers la page Saisir
                request.getRequestDispatcher("saisir").forward(request, response);               
                break;    
            case "suppr":
                //Lecture des messages
                 try {
                    List <MessageDor> list = MessageBD.lireMessages();
                    
                    //Chainage vers lire.jsp
                    RequestDispatcher rd = request.getRequestDispatcher("supprimer");
                    request.setAttribute("liste_msg", list);
                    rd.forward(request, response);
                } catch (Exception e){
                    //Chainage vers le page d'accueil avec un message
                    RequestDispatcher rd = request.getRequestDispatcher("accueil");
                    request.setAttribute("msg_erreur", e.getMessage());
                    rd.forward(request, response);               
                }
                break;
            default:
                //Chainage vers la page d'accueil
                request.getRequestDispatcher("accueil").forward(request, response); 
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

} //Fin de la servelt CtrlCentral
