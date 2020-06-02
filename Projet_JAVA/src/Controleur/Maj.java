/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import DAO.*;
import java.sql.SQLException;
import java.time.*;
import java.util.ArrayList;
import projet_java.*;

/**
 *
 * @author Nabil WOW
 */
public class Maj {
    private Utilisateur uti;
    
    public Maj(Utilisateur uti_n){
        uti = uti_n;
    }
    
    public void AjoutCoursProf(Seance seance) throws Exception{
        if(uti.GET_DROIT()== 3)
        {
            Recherche recherche = new Recherche(uti);
            ArrayList<Seance> seancelist = new ArrayList<Seance>();
            seancelist = recherche.RechercheSeanceUti();
            boolean chevauchement = false;
            
            LocalTime hdebuttest = LocalTime.parse(seance.GET_HEURE_DEBUT().toString());
            LocalTime hfintest = LocalTime.parse(seance.GET_HEURE_DEBUT().toString());
            
            for(int i=0;i<seancelist.size();i++)
            {
                LocalTime hdebut = LocalTime.parse(seance.GET_HEURE_DEBUT().toString());             
                LocalTime hfin = LocalTime.parse(seance.GET_HEURE_DEBUT().toString());               
                int diff1 = hdebut.compareTo(hdebuttest);
                int diff2 = hfin.compareTo(hdebuttest);
                int diff3 = hdebut.compareTo(hfintest);
                int diff4 = hfin.compareTo(hfintest);
                if((seance.GET_DATE().toString() != seancelist.get(i).GET_DATE().toString()) || (((diff1)<0 &&(diff2)<0)|| ((diff3)>0 &&(diff4)>0)))
                {}
                else{
                    Exception SeanceImpossible = null;
                    chevauchement = true;
                    throw SeanceImpossible;
                }               
            }
            
            if(chevauchement == false)
            {
                DAO<Seance> seancedao = new DAO_Seance();
                boolean ajout = seancedao.create(seance);
                if(ajout == false)
                {
                    Exception problemesql = null;
                    throw problemesql;
                }
            }
        }
        else
        {
            Exception erreurdroit = null;
            throw erreurdroit;
        }
    }
    
    public void AjoutProfSeance(Seance seance, int id_enseignant) throws Exception{
        
        DAO<Utilisateur> utilisateurdao = new DAO_Utilisateur();
        Utilisateur uti_enseignant = utilisateurdao.find(id_enseignant);
        Recherche recherche = new Recherche(uti_enseignant);
        ArrayList<Seance> seancelist = new ArrayList<Seance>();
        seancelist = recherche.RechercheSeanceUti();
        boolean chevauchement = false;

        LocalTime hdebuttest = LocalTime.parse(seance.GET_HEURE_DEBUT().toString());
        LocalTime hfintest = LocalTime.parse(seance.GET_HEURE_DEBUT().toString());

        for(int i=0;i<seancelist.size();i++)
        {
            LocalTime hdebut = LocalTime.parse(seance.GET_HEURE_DEBUT().toString());             
            LocalTime hfin = LocalTime.parse(seance.GET_HEURE_DEBUT().toString());               
            int diff1 = hdebut.compareTo(hdebuttest);
            int diff2 = hfin.compareTo(hdebuttest);
            int diff3 = hdebut.compareTo(hfintest);
            int diff4 = hfin.compareTo(hfintest);
            if((seance.GET_DATE().toString() != seancelist.get(i).GET_DATE().toString()) || (((diff1)<0 &&(diff2)<0)|| ((diff3)>0 &&(diff4)>0)))
            {}
            else{
                Exception SeanceImpossible = null;
                chevauchement = true;
                throw SeanceImpossible;
            }               
        }

        if(chevauchement == false)
        {
            DAO<Seance> seancedao = new DAO_Seance();
            boolean ajout = seancedao.create(seance);
            if(ajout == false)
            {
                Exception problemesql = null;
                throw problemesql;
            }
        }
    }
    
    public void AjoutSeance(Seance seance) throws Exception{
        LocalDate Mntdate = LocalDate.now();
        if(Mntdate.isBefore(seance.GET_DATE()))
        {
            LocalTime Mntheure = LocalTime.now();
            if(Mntheure.isBefore(seance.GET_HEURE_DEBUT())&&(seance.GET_HEURE_DEBUT().isBefore(seance.GET_HEURE_FIN())))
            {
                DAO<Cours> coursdao = new DAO_Cours();
                DAO<Enseignant> enseignantdao = new DAO_Enseignant();
                ArrayList<Cours> listcours = coursdao.all();
                boolean coursexistant = false;
                
                //Verification des du cours correlation avec l'enseignant
                
                for(int i=0;i<listcours.size();i++)
                {
                    if(listcours.get(i).GET_ID() == seance.GET_ID_COURS())
                    {
                        ArrayList<Integer> listenseignantid = new ArrayList<Integer>();
                        listenseignantid = seance.GET_ID_ENSEIGNANTS();
                        for(int j=0;j<listenseignantid.size();j++)
                        {
                            Enseignant enseignant = enseignantdao.find(listenseignantid.get(j));
                            ArrayList<Integer> listecoursid = new ArrayList<Integer>();
                            listecoursid = enseignant.GET_ID_COURS();
                            for(int k=0;k<listecoursid.size();k++)
                            {
                                if(listecoursid.get(k) == seance.GET_ID_COURS())
                                {
                                    coursexistant = true;
                                }
                            }
                            
                        }
                    }
                }
                if(coursexistant = true)
                {
                    //Verification du type de la séance
                    
                    DAO<Type_cours> type_coursdao = new DAO_Type_cours();
                    ArrayList<Type_cours> listetype_cours = type_coursdao.all();
                    boolean typecoursexistant = false;
                    for(int k=0;k<listetype_cours.size();k++)
                    {
                        if(listetype_cours.get(k).GET_ID() == seance.GET_ID_TYPE())
                        {
                            typecoursexistant = true;
                        }
                    }
                    if(typecoursexistant = true)
                    {
                        // Verification du chevachement des cours
                        ArrayList<Seance> touteslesseances = new ArrayList();
                        ArrayList<Integer> enseignantseanceid = seance.GET_ID_ENSEIGNANTS();
                        ArrayList<Integer> groupeseanceid = seance.GET_ID_GROUPES();
                        boolean chevauchement = false;
                        
                        for(int i=0;i<groupeseanceid.size();i++)
                        {
                            Recherche recherche = new Recherche(uti);
                            touteslesseances.addAll(recherche.RechercheSeanceGroupe(groupeseanceid.get(i)));
                        }
                        for(int i=0;i<enseignantseanceid.size();i++)
                        {
                            DAO<Utilisateur> utilisateurdao = new DAO_Utilisateur();
                            Utilisateur enseignant = utilisateurdao.find(enseignantseanceid.get(i));
                            Recherche recherche = new Recherche(enseignant);
                            touteslesseances.addAll(recherche.RechercheSeanceUti());
                        }
                        
                        for(int i=0;i<touteslesseances.size();i++)
                        {
                            LocalTime hdebuttest = LocalTime.parse(seance.GET_HEURE_DEBUT().toString());
                            LocalTime hfintest = LocalTime.parse(seance.GET_HEURE_DEBUT().toString());
                            LocalTime hdebut = LocalTime.parse(touteslesseances.get(i).GET_HEURE_DEBUT().toString());         
                            LocalTime hfin = LocalTime.parse(touteslesseances.get(i).GET_HEURE_DEBUT().toString());             
                            int diff1 = hdebut.compareTo(hdebuttest);
                            int diff2 = hfin.compareTo(hdebuttest);
                            int diff3 = hdebut.compareTo(hfintest);
                            int diff4 = hfin.compareTo(hfintest);
                            if((touteslesseances.get(i).GET_DATE().toString() != seance.GET_DATE().toString()) || (((diff1)<0 &&(diff2)<0)|| ((diff3)>0 &&(diff4)>0)))
                            {}
                            else{chevauchement = true;}
                        }
                        if(chevauchement = false)
                        {
                            // Test capacité salle
                            int capacitesalles = 0;
                            ArrayList<Integer>salleseanceid = seance.GET_ID_SALLES();
                            DAO<Salle> salledao = new DAO_Salle();
                            for(int i=0;i<groupeseanceid.size();i++)
                            {
                                Salle Tmpsalle = salledao.find(groupeseanceid.get(i));
                                capacitesalles += Tmpsalle.GET_CAPACITE();                               
                            }
                            
                            int nbreleve = 0;
                            DAO<Etudiant> etudiantdao = new DAO_Etudiant();
                            for(int i=0;i<groupeseanceid.size();i++)
                            {
                                ArrayList<Etudiant> listetudiant = etudiantdao.all();
                                for(int j=0;j<listetudiant.size();j++)
                                {
                                    if(listetudiant.get(j).GET_ID_GROUPE() ==   groupeseanceid.get(i))
                                    {
                                        nbreleve++;
                                    }
                                }
                            }
                            
                            if(capacitesalles >= nbreleve)
                            {
                                DAO<Seance> seancedao = new DAO_Seance();
                                seancedao.create(seance);
                            }
                            else
                            {
                                Exception erreurcapacité = null;
                                throw erreurcapacité;
                            }
                        }
                        else
                        {
                            Exception erreurchevauchement = null;
                            throw erreurchevauchement;
                        }
                    }
                    else
                    {
                        Exception erreurtypecours = null;
                        throw erreurtypecours;
                    }
                }
                else
                {
                    Exception erreurprofcours = null;
                    throw erreurprofcours;
                }
            }
            else
            {
                Exception erreurheure = null;
                throw erreurheure;
            }
        }
        else{
            Exception erreurdate = null;
            throw erreurdate; 
        }
    }
}


