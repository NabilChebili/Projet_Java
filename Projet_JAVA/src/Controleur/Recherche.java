/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import DAO.*;
import java.sql.SQLException;
import java.util.ArrayList;
import projet_java.*;

/**
 *
 * @author Nabil WOW
 */
public class Recherche {
    private Utilisateur uti;
    public Recherche(Utilisateur uti_n){
        uti = uti_n;
    }
    
    public ArrayList<Seance> RechercheSeanceUti() throws Exception{
        if(uti.GET_DROIT() == 3)
        {
            DAO<Enseignant> enseignantdao = new DAO_Enseignant();
            Enseignant prof = enseignantdao.find(uti.GET_ID());
            ArrayList<Integer> seanceid = new ArrayList<Integer>();
            seanceid = prof.GET_ID_SEANCES();
            ArrayList<Seance> seancelist = new ArrayList<Seance>();
            for(int i=0;i<seanceid.size();i++)
            {
                DAO<Seance> seancedao = new DAO_Seance();
                Seance seance = seancedao.find(seanceid.get(i));
                seancelist.add(seance);
                
            }
            return seancelist;
            
        }
        else if(uti.GET_DROIT()== 4)
        {
            DAO<Etudiant> etudiantdao = new DAO_Etudiant();
            Etudiant etudiant = etudiantdao.find(uti.GET_ID());
            int groupeid = etudiant.GET_ID_GROUPE();
            DAO<Groupe> groupedao = new DAO_Groupe();
            Groupe groupe = groupedao.find(groupeid);
            
            ArrayList<Integer> seanceid = new ArrayList<Integer>();
            seanceid = groupe.GET_ID_SEANCES();
            ArrayList<Seance> seancelist = new ArrayList<Seance>();
            for(int i=0;i<seanceid.size();i++)
            {
                DAO<Seance> seancedao = new DAO_Seance();
                Seance seance = seancedao.find(seanceid.get(i));
                seancelist.add(seance);
                
            }
            return seancelist;
            
        }
        else 
        {
            Exception erreurdroit = null;
            throw erreurdroit;
        }
        
    }
    public ArrayList<Seance> RechercheSeanceGroupe(int id_groupe)
    {
        DAO<Groupe> groupedao = new DAO_Groupe();
        Groupe groupe = groupedao.find(id_groupe);
        ArrayList<Integer> seanceid = new ArrayList<Integer>();
        seanceid = groupe.GET_ID_SEANCES();
        ArrayList<Seance> seancelist = new ArrayList<Seance>();
        for(int i=0;i<seanceid.size();i++)
        {
            DAO<Seance> seancedao = new DAO_Seance();
            Seance seance = seancedao.find(seanceid.get(i));
            seancelist.add(seance);

        }
        return seancelist;
            
    }
    
    public ArrayList<Seance> RechercheSeanceSalle(int id_salle)
    {
        DAO<Salle> salledao = new DAO_Salle();
        Salle salle = salledao.find(id_salle);
        ArrayList<Integer> seanceid = new ArrayList<Integer>();
        seanceid = salle.GET_ID_SEANCES();
        ArrayList<Seance> seancelist = new ArrayList<Seance>();
        for(int i=0;i<seanceid.size();i++)
        {
            DAO<Seance> seancedao = new DAO_Seance();
            Seance seance = seancedao.find(seanceid.get(i));
            seancelist.add(seance);

        }
        return seancelist;     
    }
    
    public ArrayList<Seance> RechercheSeanceCours(int id_salle)
    {
        DAO<Salle> salledao = new DAO_Salle();
        Salle salle = salledao.find(id_salle);
        ArrayList<Integer> seanceid = new ArrayList<Integer>();
        seanceid = salle.GET_ID_SEANCES();
        ArrayList<Seance> seancelist = new ArrayList<Seance>();
        for(int i=0;i<seanceid.size();i++)
        {
            DAO<Seance> seancedao = new DAO_Seance();
            Seance seance = seancedao.find(seanceid.get(i));
            seancelist.add(seance);
        }
        return seancelist;     
    }
    
    
    
    
    public void recherche(Connexion conn) {
        conn.GET_UTI();
    }
    
    
        
    
    
    
    
}
