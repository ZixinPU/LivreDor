/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miage.metier;

/**
 *
 * @author zixin
 */
//Classe message d'or
public class MessageDor {
    private long id;
    private String pseudo;
    private String message;
    
    //Constructeur
    public MessageDor(long id, String pseudo, String message) {
        this.id = id;
        this.pseudo = pseudo;
        this.message = message;
    }

    public MessageDor(String pseudo, String message) {
        this.pseudo = pseudo;
        this.message = message;
    }
    
    //getter et setter
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}   
    public String getPseudo() {return pseudo;}
    public void setPseudo(String pseudo) {this.pseudo = pseudo;}
    public String getMessage() {return message;}   
    public void setMessage(String message) {this.message = message;}
    
    //Méthode toString 
    @Override
    public String toString() {
        return "MessageDor{" + "id=" + id + ", pseudo=" + pseudo + ", message=" + message + '}';
    }
    
    
    
}
