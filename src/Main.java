import players.EnsJoueurs;
import players.Joueur;
import question.Themes;
import question.TypeQCM;
import question.Question;
import question.ListeQuestions;
import question.TypeRC;
import question.TypeVF;
import question.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "assets/";

        ArrayList<TypeQCM> a = new ArrayList<>(); // QCM
        ArrayList<TypeVF> b = new ArrayList<>(); // Vrai/Faux
        ArrayList<TypeRC> c = new ArrayList<>(); // Répnses courtes


        ArrayList<String> bonReponse = new ArrayList<>(); // liste des réponses par rapport a un type


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

        ListeQuestions questi = new ListeQuestions(thema);

        if(aleaType == 0) {
            System.out.println("--------------------- Type QCM ---------------------");
            for (TypeQCM e : a) {
                if(e.getTheme().equals(thema.getThemeCourant())){
                    Question q = new Question(numq,e);
                    bonReponse.add(e.getRepBonQCM());
                    numq += 1;
                    questi.ajouter(q);
                }
            }
        }else if (aleaType == 1){
            System.out.println("--------------------- Type VF ---------------------");
            for (TypeVF e: b) {
                if(e.getTheme().equals(thema.getThemeCourant())){
                    Question q = new Question(numq,e);
                    numq += 1;
                    questi.ajouter(q);
                }
            }
        }else{
            System.out.println("--------------------- Type RC ---------------------");
            for (TypeRC e : c) {
                if(e.getTheme().equals(thema.getThemeCourant())){
                    Question q = new Question(numq,e);
                    numq += 1;
                    questi.ajouter(q);
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
        questi.afficher();
        System.out.println(bonReponse);

        // Création de l'ensemble des joueurs
        EnsJoueurs e = new EnsJoueurs();
        e.creer();
        e.afficher();

        //System.out.println("---------------------Sélection des joueurs---------------------");
        //for (Joueur j : e.selectionnerJoueurs()) {
         //   j.afficher();
       // }

        e.selectionnerJoueurs();
        e.afficher();

        //for(Joueur j: e){

        //}
        System.out.println(bonReponse.get(10));
        System.out.println("Joueur");


        for(int j = 0; j < 20; j++){
            if(e.getelement(j).getEtat().equals("sélectionné")){
                jeuPhase1(questi,bonReponse,e.getelement(j),aleaType);
            }
        }

        //phaseDeJeu(e);
    }
    //phaseDeJeu(e);
//}

    public static void jeuPhase1(ListeQuestions questi,ArrayList<String> bonReponse, Joueur j, int type){
        System.out.println("Joueur " + j.getNom() + " c'est à vous de jouer");
        //Scanner sc = new Scanner(System.in);
        String reponse = "jean";
        if(type == 0){
            //type = QCM
            int i = 0;
            Question<TypeQCM> selec = null;
            while(selec == null) {
                i = (int) (Math.random() * 100 % ListeQuestions.getList().size());
                System.out.println(i);
                selec = questi.selectionnerQuestion(1, i);
            }
            Question<TypeQCM> q = new Question<TypeQCM>(1, (TypeQCM) selec.getEnonceQ());
            q.afficher();
            System.out.println(bonReponse.get(i));
            //estBonneReponseQCM(q,reponse);
            //if(isTheGoodAnswer(q,reponse));
        }else if (type == 1){
            //type vrai/faux
            Question<TypeVF> q= new Question<TypeVF>(1, (TypeVF) questi.selectionnerQuestion(1,1).getEnonceQ());
            q.afficher();
        }else{
            //type réponse courte
            Question<TypeRC> q= new Question<TypeRC>(1, (TypeRC) questi.selectionnerQuestion(1,1).getEnonceQ());
            q.afficher();
        }

    }

    public static void phaseDeJeu(EnsJoueurs e) {
        Joueur[] Joueurs = e.selectionnerJoueurs();
        Themes theme;
        premierephase(Joueurs);
        secondephase(Joueurs);
        finalphase(Joueurs);
    }

    public static <T> void premierephase(Joueur[] Joueurs){

        /*ce que j'essaie maladroitement de faire :
        je selectionne un theme
        ensuite je selectionne la liste de questions correspondants à ce theme
        je selectionne une question de niveau 1 pour la poser à un joueur
         */
        System.out.println("a");
        Themes theme = new Themes();
        System.out.println(theme.selectionnerTheme());
        ListeQuestions questions = new ListeQuestions(theme);
        for(int i=0;i<Joueurs.length;i++){
            Question q = questions.selectionnerQuestion(1,1);
            //q.afficher();
            if (isTheGoodAnswer(q,selectionReponse())){
                Joueurs[i].mAJScore(2);
            }
        }
    }

    public static void secondephase(Joueur[] Joueurs){
    }

    public static void finalphase(Joueur[] Joueurs){

    }

    public static <TypeQCM> boolean estBonneReponseQCM(Question q, String reponse){
        System.out.println("a ");
        System.out.println("a " + q.bonRepQCM(q.getEnonceQ()));
        return true;
    }

    public static <T> boolean isTheGoodAnswer(Question q, String reponse){
        System.out.println("a " + q.bonneReponse((T) q));
        if (q.bonneReponse((T) q).equals(reponse)){
            return true;
        }
        return false;
    }
    public static String selectionReponse(){
        //TODO: demander une réponse au joueur
        return null;
    }

}
