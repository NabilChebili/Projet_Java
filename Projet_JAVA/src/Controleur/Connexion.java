/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import DAO.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nabil WOW
 */
public class Connexion {

    public Utilisateur uti;

    public Connexion() {
    }

    public boolean connexion(String Idtest, String Mdptest) {
        DAO<Utilisateur> utilisateurdao = new DAO_Utilisateur();
        uti = new Utilisateur();
        uti = utilisateurdao.find(Idtest, Mdptest);

        if (uti.GET_ID() == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Utilisateur GET_UTI() {
        return uti;
    }
}
