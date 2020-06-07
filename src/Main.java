import players.EnsJoueurs;
import players.Joueur;
<<<<<<< HEAD
import question.Themes;
import question.TypeQCM;
import question.Question;
import question.TypeRC;
import question.TypeVF;
=======
import question.*;
>>>>>>> master

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "assets/";

        ArrayList<TypeQCM> a = new ArrayList<>(); // QCM
        ArrayList<TypeVF> b = new ArrayList<>(); // Vrai/Faux
        ArrayList<TypeRC> c = new ArrayList<>(); // Répnses courtes


        ArrayList<Question> ListeTheme = new ArrayList<>(); // liste de question pour thème courant


        // Initialisation des questions
        File f = new File(path + "quizz.txt");
        Scanner sc = new Scanner(f);

        String line = null;

        while (sc.hasNext()) {
            line = sc.nextLine();

            // Récup les RC
            if (line.equals("rc")){
                TypeRC q = new TypeRC(sc);
                c.add(q);
            }

            // Récup les QCM
            if (line.equals("qcm")){
                TypeQCM q = new TypeQCM(sc);
                a.add(q);
            }

            // Récup les VF
            if (line.equals("vf")){
                TypeVF q = new TypeVF(sc);
                b.add(q);
            }
        }


        //On choisis aléatoirement un type de question
        int aleaType = (int) (Math.random() * 100) % 3;
        System.out.println("aleatype =" + aleaType);

        //on déclare un numéro de question qui sera incrémenter
        int numq = 0;

        //On déclare un thème et on initialise le themeCourant
        Themes thema = new Themes();
        thema.selectionnerTheme();
        System.out.println(thema.getThemeCourant());

        if(aleaType == 0) {
            System.out.println("--------------------- Type QCM ---------------------");
            for (TypeQCM e : a) {
                if(e.getTheme().equals(thema.getThemeCourant())){
                    Question q = new Question(numq,e);
                    numq += 1;
                    ListeTheme.add(q);
                }
            }
        }else if (aleaType == 1){
            System.out.println("--------------------- Type VF ---------------------");
            for (TypeVF e: b) {
                if(e.getTheme().equals(thema.getThemeCourant())){
                    Question q = new Question(numq,e);
                    numq += 1;
                    ListeTheme.add(q);
                }
            }
        }else{
            System.out.println("--------------------- Type RC ---------------------");
            for (TypeRC e : c) {
                if(e.getTheme().equals(thema.getThemeCourant())){
                    Question q = new Question(numq,e);
                    numq += 1;
                    ListeTheme.add(q);
                }
            }
        }

        /*
        //Affichage de toutes les questions par type
        System.out.println("--------------------- Affichage des QCM---------------------");
        for (TypeQCM e : a) {
            e.afficher();
        }
        System.out.println();

        System.out.println("---------------------Affichage des Vrai/Faux---------------------");
        for (TypeVF e: b) {
            e.afficher();
        }
        System.out.println();

        System.out.println("---------------------Affichage des Réponses courtes---------------------");
        for (TypeRC e : c) {
            e.afficher();
        }
        System.out.println();
        */

        //Affichage de l'Arraylist créé
        for(Question j: ListeTheme){
            j.afficher();
        }


        // Création de l'ensemble des joueurs
        EnsJoueurs e = new EnsJoueurs();
        e.creer();
        e.afficher();

        System.out.println("---------------------Sélection des joueurs---------------------");
        for (Joueur j : e.selectionnerJoueurs()) {
            j.afficher();
        }
<<<<<<< HEAD
    }
=======
    phaseDeJeu(e);
    }


    public static void phaseDeJeu(EnsJoueurs e) {
        Joueur[] Joueurs = e.selectionnerJoueurs();
        Themes theme;
        premierephase(Joueurs);
    }

    public static <T> void premierephase(Joueur[] Joueurs){

        /*ce que j'essaie maladroitement de faire :
        je selectionne un theme
        ensuite je selectionne la liste de questions correspondants à ce theme
        je selectionne une question de niveau 1 pour la poser à un joueurje
         */
        Themes theme = new Themes();
        theme.selectionnerTheme();
        ListeQuestions questions = new ListeQuestions(theme);
        for(int i=0;i<Joueurs.length;i++){
            Question q = questions.selectionnerQuestion(1);
            q.afficher();
            if (isTheGoodAnswer(q,selectionReponse())){
                Joueurs[i].mAJScore(2);
            }
        }
        secondephase(Joueurs);
    }

    public static void secondephase(Joueur[] Joueurs){
        finalphase(Joueurs);
    }

    public static void finalphase(Joueur[] Joueurs){

    }

    public static <T> boolean isTheGoodAnswer(Question q, String reponse){
        if (q.bonneReponse((T) q).equals(reponse)){
            return true;
        }
        return false;
    }
    public static String selectionReponse(){
        //TODO: demander une réponse au joueur
        return null;
    }

>>>>>>> master
}
