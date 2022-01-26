/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miage.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import miage.metier.MessageDor;

/**
 *
 * @author zixin
 */
//Classe de Mapping Objet Relationnel avec la classe de message
public class MessageBD {
    //propriétés
    private static final String URL = "jdbc:mysql://localhost:3307/db_21613582_2";
    private static final String LOGIN = "21613582"; 
    private static final String PWD = "R028J3";
    
    private static Connection cx = null;
    
    //Méthode de connexion à la BD
    public static void connexion () throws Exception{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException cnfe) { 
        throw new Exception("MessageBD - connexion() - " + cnfe.getMessage());
        }
        try{
            cx = (Connection) DriverManager.getConnection(URL,LOGIN,PWD);
        }
        catch (SQLException sqle){
            throw new Exception ("MessageBD - connexion() - " + sqle.getMessage());          
        }
    }
    
    //Méthode pour enregistrer un message d'or
    public static void enregistrerMessage(MessageDor msg) throws Exception{
        if (cx == null)
            MessageBD.connexion();
        
        //Requête 
        String sql = "INSERT INTO Message (Pseudo, Message) VALUES (?,?)";
        
        //Ouverture de l'espace de requête
        try (PreparedStatement st = cx.prepareStatement(sql)){
            //Affecter des paramètres
            st.setString(1, msg.getPseudo());
            st.setString(2, msg.getMessage());
            
            //Mise à jour
            st.executeUpdate();
                       
        }catch (SQLException sqle){
            throw new Exception ("MessageBD.enregistrerMessage() - " + sqle.getMessage());                    
        }    
                
    }
    
    //Méthode pour charger les messages d'or
    public static List<MessageDor> lireMessages() throws Exception{
        if (cx == null)
            MessageBD.connexion();
            
        List<MessageDor> liste = new ArrayList<>();
        
        //requête SQL
        String sql = "SELECT * FROM Message";
        
        //ouverture d'un espace de requête
        try (PreparedStatement st = cx.prepareStatement(sql)){
            //Interroger la BD
            ResultSet rs = st.executeQuery();
            
            //Lire le résultat
            while (rs.next()){
                MessageDor msg = new MessageDor (rs.getInt("NumMsg"), 
                                                 rs.getString("Pseudo"), 
                                                 rs.getString("Message"));
                
                liste.add(msg);
            }
            
        }catch (SQLException sqle){
            throw new Exception ("MessageBD.lireMessages() - " + sqle.getMessage());           
        }    
        
        return liste;        
    }
    
    //Programme de test
    public static void main(String[] args) {
        try{
            MessageBD.connexion();
            System.out.println("Connexion réussite !");
            
            //Ajouter un message
            MessageDor m1 = new MessageDor ("Cela", "marche !");
            MessageBD.enregistrerMessage(m1);
            
            //Affichage de la liste de messages
            List<MessageDor> list = MessageBD.lireMessages();
            for(MessageDor msg: list)
                System.out.println(msg);
            
        }catch (Exception ex){
            System.out.println("Erreur lors de la connexion - " + ex.getMessage());
        }
    }
}
