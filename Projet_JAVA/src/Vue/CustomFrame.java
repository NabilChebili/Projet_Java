/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.*;
import DAO.*;
import static Vue.CoursWidget.setFontSizeMax;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.*;
import static javax.swing.JFrame.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pierr
 */
public class CustomFrame extends JFrame implements ActionListener {

    private Color gris;
    private Color grisFonce;
    private Color blanc;
    private Color bleu;

    private Utilisateur uti;

    private JFrame fMain;
    private JPanel pMenu;
    private JLayeredPane pContent;
    private JLayeredPane pProf;

    private ArrayList<CoursWidget> pSemaine;

    private JTextField semaineText;
    private int semaineNbr = -1;
    private String semaineNom = "Semaine : ";
    private JLabel semaineRecherche;

    private JLabel speL;
    private JButton speB;
    private JTextField speF;
    
    private JLabel speCoursL;
    private JTextField speCoursF;

    private JTextField creneauF;
    private JTextField dateF;
    private JTextField idCoursF;
    private JTextField typeCoursF;
    private JTextField enseignantsF;
    private JTextField groupesF;
    private JTextField sallesF;
    private JTextField promotionF;
    
    private JTextField idSeanceF;

    final private int height = 1000;
    final private int width = 1600;
    final private int menu = 400;
    final static private int sizeX = 175;
    final static private int sizeY = 100;

    private String typeRecherche = "Normal";

    public static void main(String args[]) {
        new CustomFrame().setVisible(true);
    }

    public CustomFrame(Utilisateur tmputi) {
        this.uti = tmputi;
        initEDT();
    }

    public CustomFrame() {
        initEDT();
    }

    public static int getSizeX() {
        return sizeX;
    }

    public static int getSizeY() {
        return sizeY;
    }

    public void setUti(Utilisateur tmputi) {
        this.uti = tmputi;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        switch (action) {
            case "Mes Cours":
                System.out.println("Mes Cours Pressed");
                pContent.removeAll();
                fMain.revalidate();
                initContent();
                fMain.repaint();
                typeRecherche = "Normal";
                break;
            case "Les Classes":
                System.out.println("Les CLasses Pressed");
                pContent.removeAll();
                initContent();
                coursSpec("Classes");

                fMain.repaint();
                fMain.revalidate();
                break;
            case "Les Salles":
                System.out.println("Les Salles  Pressed");
                pContent.removeAll();
                initContent();
                coursSpec("Salles");

                fMain.repaint();
                fMain.revalidate();
                break;
            case "Ajout de cours":
                System.out.println("Ajout de cours  Pressed");
                pContent.removeAll();

                ajoutProf("Ajouter un cours:");

                fMain.repaint();
                fMain.revalidate();
                break;
            case "Update de cours":
                System.out.println("Update de cours  Pressed");
                pContent.removeAll();

                updateProf("Update un cours:");

                fMain.repaint();
                fMain.revalidate();
                break;
            case "Rechercher":
                System.out.println("Criteria Rechercher Pressed");
                semaineNom = "Semaine: " + semaineText.getText();
                semaineNbr = Integer.parseInt(semaineText.getText());
                System.out.println(semaineNbr);
                pContent.removeAll();
                initContent();

                fMain.repaint();
                fMain.revalidate();
                break;
            case "Classes":
                System.out.println("Criteria Classes Pressed");
                typeRecherche = "Classe";
                pContent.removeAll();
                initContent();
                // Implementer la recherche pour les cours
                // Obtient le cours recherché  ->  speF.getText();
                // Obtient la proma avec speCoursF.getText();
                break;
            case "Salles":
                System.out.println("Criteria Salles Pressed");
                typeRecherche = "Salle";
                pContent.removeAll();
                initContent();
                // Implementer la recherche pour les cours
                // Obtient le cours recherché  ->  speF.getText();
                break;
            case "AJOUTER": 
                System.out.println("Criteria Ajouter - Prof Pressed");
                break;
            default:
                break;
        }
    }
    
    private void updateProf(String titreC) {
        
        ajoutProf(titreC);
        JLabel idSeance = new JLabel("ID Cours: ");
        idSeance.setBounds(menu + 20, 20 + 50 + 0, 150, 30);
        idSeanceF = new JTextField();
        idSeanceF.setBounds(menu + 20 + 130, 20 + 50 + 0, 150, 30);
        
        pContent.add(idSeance);
        pContent.add(idSeanceF);
    }

    private void ajoutProf(String titreC) {

        JLabel titre = new JLabel(titreC);
        titre.setBounds(menu + 20, 5, 500, 50);
        titre.setForeground(gris);
        titre.setFont(new Font("Arial", Font.PLAIN, 30));

        JLabel creneau = new JLabel("Horaire: ");
        JLabel date = new JLabel("Date: ");
        JLabel idCours = new JLabel("Nom du cours: ");
        JLabel typeCours = new JLabel("Type de cours: ");
        JLabel enseignants = new JLabel("nom des enseignants: ");
        JLabel groupes = new JLabel("Nom des groupes: ");
        JLabel salles = new JLabel("Numéros des salles: ");
        JLabel promotion = new JLabel("Promotion: ");

        creneau.setBounds(menu + 20, 20 + 80 + 10, 150, 30);
        date.setBounds(menu + 20, 50 + 80 + 20, 150, 30);
        idCours.setBounds(menu + 20, 80 + 80 + 30, 150, 30);
        typeCours.setBounds(menu + 20, 110 + 80 + 40, 150, 30);
        enseignants.setBounds(menu + 20, 140 + 80 + 50, 150, 30);
        groupes.setBounds(menu + 20, 170 + 80 + 60, 150, 30);
        salles.setBounds(menu + 20, 200 + 80 + 70, 150, 30);
        promotion.setBounds(menu + 20, 230 + 80 + 80, 150, 30);

        creneauF = new JTextField();
        dateF = new JTextField();
        idCoursF = new JTextField();
        typeCoursF = new JTextField();
        enseignantsF = new JTextField();
        groupesF = new JTextField();
        sallesF = new JTextField();
        promotionF = new JTextField();

        creneauF.setBounds(menu + 20 + 130, 20 + 80 + 10, 150, 30);
        dateF.setBounds(menu + 20 + 130, 50 + 80 + 20, 150, 30);
        idCoursF.setBounds(menu + 20 + 130, 80 + 80 + 30, 150, 30);
        typeCoursF.setBounds(menu + 20 + 130, 110 + 80 + 40, 150, 30);
        enseignantsF.setBounds(menu + 20 + 130, 140 + 80 + 50, 150, 30);
        groupesF.setBounds(menu + 20 + 130, 170 + 80 + 60, 150, 30);
        sallesF.setBounds(menu + 20 + 130, 200 + 80 + 70, 150, 30);
        promotionF.setBounds(menu + 20 + 130, 230 + 80 + 80, 150, 30);

        JButton validerAjout = new JButton("AJOUTER");
        validerAjout.setBounds(menu + 20, 230 + 100 + 100, 150, 30);
        validerAjout.addActionListener(this);

        pContent.add(validerAjout);
        pContent.add(titre);

        pContent.add(creneau);
        pContent.add(date);
        pContent.add(idCours);
        pContent.add(typeCours);
        pContent.add(enseignants);
        pContent.add(groupes);
        pContent.add(salles);
        pContent.add(promotion);
        pContent.add(creneauF);
        pContent.add(dateF);
        pContent.add(idCoursF);
        pContent.add(typeCoursF);
        pContent.add(enseignantsF);
        pContent.add(groupesF);
        pContent.add(sallesF);
        pContent.add(promotionF);
    }

    private void coursSpec(String monTypeField) {
        speL = new JLabel(monTypeField + " :");
        speF = new JTextField();
        speB = new JButton(monTypeField);

        speB.addActionListener(this);
        speL.setBounds(menu + 10, 40, 100, 20);
        speF.setBounds(menu + 120, 40, 100, 20);
        speB.setBounds(menu + 180 + 50, 40, 35, 20);

        if ("Classes".equals(monTypeField)) {
            speCoursL = new JLabel("Promotion :");
            speCoursF = new JTextField();
            speCoursL.setBounds(menu + 240, 40, 100, 20);
            speCoursF.setBounds(menu + 360, 40, 100, 20);
            speB.setBounds(menu + 470, 40, 35, 20);
            pContent.add(speCoursL);
            pContent.add(speCoursF);
        }

        pContent.add(speL);
        pContent.add(speF);
        pContent.add(speB);
    }

    private void initEDT() {

        gris = Color.decode("#303a52");
        grisFonce = Color.decode("#202a42");
        blanc = Color.decode("#e2f3f5");
        bleu = Color.decode("#1f4287");

        fMain = new JFrame("ECE-Agenda");
        fMain.setSize(width, height);
        fMain.setLocation((1920 / 2) - (width / 2), (1080 / 2) - (height / 2));
        fMain.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fMain.setVisible(true);
        fMain.setResizable(false);

        pMenu = new JPanel();
        pMenu.setSize(menu, height);
        pMenu.setLocation(0, 0);
        pMenu.setBackground(gris);
        pMenu.setLayout(null);

        pContent = new JLayeredPane();
        pContent.setSize(width - menu, height);
        pContent.setLocation(menu, 0);
        pContent.setBackground(Color.RED);

        fMain.add(pMenu);
        fMain.add(pContent);

        initContent();

        JButton bMesCours = new JButton("Mes Cours");
        bMesCours.setBackground(grisFonce);
        bMesCours.setForeground(blanc);
        bMesCours.setFont(new Font("Arial", Font.PLAIN, 30));

        JButton bMesClasses = new JButton("Les Classes");
        bMesClasses.setBackground(grisFonce);
        bMesClasses.setForeground(blanc);
        bMesClasses.setFont(new Font("Arial", Font.PLAIN, 30));

        JButton bMesSalles = new JButton("Les Salles");
        bMesSalles.setBackground(grisFonce);
        bMesSalles.setForeground(blanc);
        bMesSalles.setFont(new Font("Arial", Font.PLAIN, 30));

        bMesCours.addActionListener(this);
        bMesClasses.addActionListener(this);
        bMesSalles.addActionListener(this);
        bMesCours.setBounds(0, 300, menu, 50);
        bMesClasses.setBounds(0, 350, menu, 50);
        bMesSalles.setBounds(0, 400, menu, 50);
        pMenu.add(bMesCours);
        pMenu.add(bMesClasses);
        pMenu.add(bMesSalles);

        if (true) {
            //if (uti.GET_DROIT() == 3) {
            JButton inputProf = new JButton("Ajout de cours");
            inputProf.setBackground(grisFonce);
            inputProf.setForeground(blanc);
            inputProf.setFont(new Font("Arial", Font.PLAIN, 30));
            inputProf.addActionListener(this);
            inputProf.setBounds(0, 450, menu, 50);
            pMenu.add(inputProf);
            
            JButton updateProf = new JButton("Update de cours");
            updateProf.setBackground(grisFonce);
            updateProf.setForeground(blanc);
            updateProf.setFont(new Font("Arial", Font.PLAIN, 30));
            updateProf.addActionListener(this);
            updateProf.setBounds(0, 500, menu, 50);
            pMenu.add(updateProf);
        }

        JLabel intro = new JLabel("Planning's");
        intro.setFont(new Font("Arial", Font.PLAIN, 45));
        intro.setForeground(blanc);
        intro.setBounds(menu / 2 - 220 / 2, 30, 220, 50);
        pMenu.add(intro);

        fMain.revalidate();
        fMain.repaint();
    }

    private void initContent() {
        ArrayList stringcours = new ArrayList<>();
        ArrayList stringprof = new ArrayList<>();

        if (semaineNbr != -1) {
            DAO<Utilisateur> utilisateurdao = new DAO_Utilisateur();
            DAO<Cours> coursdao = new DAO_Cours();
            DAO<Promotion> promotiondao = new DAO_Promotion();
            ArrayList<Cours> cours = coursdao.all();
            ArrayList<Utilisateur> prof = utilisateurdao.all();
            ArrayList<Promotion> promotion = promotiondao.all();

            Recherche rech = new Recherche(uti);
            ArrayList<Seance> seances = new ArrayList<>();
            try {
                boolean test;
                switch (typeRecherche) {
                    case "Normal":
                        seances.addAll(rech.RechercheSeanceUti());
                        break;
                    case "Classe":
                        System.out.println("Aucun groupe trouvé");
                        DAO<Groupe> groupedao = new DAO_Groupe();
                        ArrayList<Groupe> groupe = groupedao.all();
                        test = false;

                        System.out.println(speF.getText());
                        for (int i = 0; i < groupe.size(); i++) {
                            System.out.println(i + " : " + groupe.get(i).GET_NOM());
                            for (int j = 0; j < promotion.size(); j++) {
                                if ((promotion.get(j).GET_NOM().equals(speCoursF.getText())) && (groupe.get(i).GET_ID_PROMOTION() == promotion.get(j).GET_ID())) {
                                    if (speF.getText().equals(groupe.get(i).GET_NOM())) {
                                        seances.addAll(rech.RechercheSeanceGroupe(groupe.get(i).GET_ID()));
                                        test = true;
                                    }
                                }

                            }

                        }
                        if (test == false) {
                            System.out.println("Aucun groupe trouvé");
                        }
                        break;
                    case "Salle":
                        DAO<Salle> salledao = new DAO_Salle();
                        ArrayList<Salle> salle = salledao.all();
                        test = false;
                        for (int i = 0; i < salle.size(); i++) {
                            System.out.println("salle :" + i + ", " + salle.get(i).GET_NOM());
                            if (speF.getText().equals(salle.get(i).GET_NOM())) {
                                seances.addAll(rech.RechercheSeanceSalle(salle.get(i).GET_ID()));
                                test = true;
                            }
                        }
                        if (test == false) {
                            System.out.println("Aucune salle trouvé");
                        }
                        break;

                }

            } catch (Exception ex) {
                System.out.println("Erreur Recherche");
                ex.printStackTrace();
            }
            System.out.println(typeRecherche);
            for (int i = 0; i < seances.size(); i++) {
                System.out.println("Seance :" + i + ", " + seances.get(i).GET_ID());
            }

            boolean trouve = false;
            for (int i = 0; i < 6; i++) {
                //Jour

                for (int j = 0; j < 7; j++) {
                    //Heure

                    for (int k = 0; k < seances.size(); k++) {
                        if (seances.get(k).GET_SEMAINE() == semaineNbr) {
                            if (seances.get(k).GET_DATE().getDayOfWeek().getValue() - 1 == i) {
                                int heure = getintheure(seances.get(k).GET_HEURE_DEBUT().toString());
                                if (heure == j) {
                                    for (int l = 0; l < cours.size(); l++) {
                                        if (seances.get(k).GET_ID_COURS() == cours.get(l).GET_ID()) {
                                            stringcours.add(cours.get(l).GET_NOM());
                                        }
                                    }
                                    for (int l = 0; l < prof.size(); l++) {
                                        if (seances.get(k).GET_ID_ENSEIGNANTS().get(0) == prof.get(l).GET_ID()) {
                                            stringprof.add(prof.get(l).GET_NOM());
                                        }
                                    }
                                    trouve = true;
                                }

                            }
                        }

                    }

                    if (trouve == false) {
                        stringcours.add("-1");
                        stringprof.add("-1");
                    } else {
                        trouve = false;
                    }

                }
            }
        } else {
            for (int i = 0; i < 6; i++) {

                for (int j = 0; j < 7; j++) {
                    stringcours.add("-1");
                    stringprof.add("-1");
                }

            }
        }

        pSemaine = new ArrayList<>();

        System.out.println(stringcours);
        System.out.println(stringprof);

        initArray(pSemaine, 0, 115, 5, 7, bleu, stringcours, stringprof);

        Grille tmp = new Grille(menu + 10, sizeY, bleu, sizeX);
        tmp.addPanel(pContent);

        semaineRecherche = new JLabel(semaineNom);
        semaineText = new JTextField();
        JButton semaineButton = new JButton("Rechercher");
        semaineButton.addActionListener(this);
        semaineRecherche.setBounds(menu + 10, 10, 100, 20);
        semaineText.setBounds(menu + 120, 10, 50, 20);
        semaineButton.setBounds(menu + 180, 10, 35, 20);

        /*JLabel nom = new JLabel(uti.GET_NOM());
        JLabel prenom = new JLabel(uti.GET_PRENOM());
        String droit;
        switch (uti.GET_DROIT()) {
            case 1:
                droit = "Admin";
                break;
            case 2:
                droit = "Superviseur";
                break;
            case 3:
                droit = "Enseignant";
                break;
            case 4:
                droit = "Etudiant";
                break;
            default:
                System.out.println("Erreur Sur le type d'utilisateur");
                droit = "Erreur";
                break;
        }
        JLabel role = new JLabel(droit);
        JLabel mail = new JLabel(uti.GET_EMAIL());

        nom.setFont(new Font("Arial", Font.PLAIN, 20));
        prenom.setFont(new Font("Arial", Font.PLAIN, 20));
        role.setFont(new Font("Arial", Font.PLAIN, 20));
        mail.setFont(new Font("Arial", Font.PLAIN, 20));

        nom.setBounds(1400, 50, 100, 50);
        prenom.setBounds(1450, 50, 100, 50);
        role.setBounds(1400, 100, 100, 30);
        mail.setBounds(1430, 50, 100, 70);

        pContent.add(nom);
        pContent.add(prenom);
        pContent.add(role);
        pContent.add(role);
        pContent.add(mail);*/
        pContent.add(semaineText);
        pContent.add(semaineButton);
        pContent.add(semaineRecherche);
    }

    private void initArray(ArrayList<CoursWidget> semaine, int x, int y, int gap, int nbColumn, Color color, ArrayList<String> myLabel, ArrayList<String> myProf) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < nbColumn; j++) {
                CoursWidget pElem = new CoursWidget(myLabel.get(i * nbColumn + j), myProf.get(i * nbColumn + j), color, sizeX, sizeY, menu + 80 + (sizeX + 10) * i, y + (sizeY + gap * 4) * j, gap);
                semaine.add(pElem);
            }
        }
        linkArray(semaine, pContent);
    }

    private void linkArray(ArrayList<CoursWidget> from, JLayeredPane to) {
        for (int i = 0; i < from.size(); i++) {
            to.add(from.get(i).getCours(), 2);
        }
    }

    public void toggleVisibility() {
        if (pContent.isVisible()) {
            pContent.setVisible(false);
            //pProf.setVisible(true);
        } else {
            pContent.setVisible(true);
            //pProf.setVisible(false);
        }
    }

    public int getintheure(String i) {
        switch (i) {
            case "08:30":
                return 0;
            case "10:15":
                return 1;
            case "12:00":
                return 2;
            case "13:45":
                return 3;
            case "15:30":
                return 4;
            case "17:15":
                return 5;
            case "19:00":
                return 6;
        }
        return 0;
    }
}
