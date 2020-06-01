/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Nabil WOW
 */
public class Etudiant {
    private int ID_UTILISATEUR;
    private int NUMERO;
    private int ID_GROUPE;
    
    public Etudiant(int id,int numero,int id_groupe){
        this.ID_UTILISATEUR = id ;
        this.NUMERO = numero ;
        this.ID_GROUPE = id_groupe ;
    }
    
    public int GET_ID_UTILISATEUR (){
        return ID_UTILISATEUR;
    }
    public int GET_NUMERO (){
        return NUMERO;
    }
    public int GET_ID_GROUPE() {
        return ID_GROUPE;
    } 
}
