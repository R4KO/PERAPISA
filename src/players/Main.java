package src.players;

import src.players.EnsJoueurs;
import src.players.Joueur;
import src.question.Themes;
import src.question.TypeQCM;
import src.question.Question;
import src.question.ListeQuestions;
import src.question.TypeRC;
import src.question.TypeVF;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "build/classes/assets/";

        Scanner sce = new Scanner (System.in);

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

        System.out.println(thema.getListTheme());
        //On supprime dans la liste le thème pour ne pas le réutiliser
        thema.enleverTheme(thema.getThemeCourant());

        System.out.println(thema.getListTheme());

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
                    if(e.isReponse()){
                        bonReponse.add("vrai");
                    }else{bonReponse.add("faux");}
                    //System.out.println(e.isReponse());
                    numq += 1;
                    questi.ajouter(q);
                }
            }
        }else{
            System.out.println("--------------------- Type RC ---------------------");
            for (TypeRC e : c) {
                if(e.getTheme().equals(thema.getThemeCourant())){
                    Question q = new Question(numq,e);
                    bonReponse.add(e.getReponse());
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
        //System.out.println(bonReponse.get(10));
        //System.out.println("Joueur");
                                        // Phase n°1

        for(int j = 0; j < 20; j++){
            if(e.getelement(j).getEtat().equals("sélectionné")){
                jeuPhase1(questi,bonReponse,e.getelement(j),aleaType);
                e.getelement(j).afficher();
                System.out.println("\n\n");
            }
        }

        int nbMin = 20;
        Joueur jElim = null;
        for(int j = 0; j < 20; j++){
            if(e.getelement(j).getEtat().equals("sélectionné")){
                if(e.getelement(j).getScore() < nbMin){
                    jElim = e.getelement(j);
                    nbMin = e.getelement(j).getScore();
                }else if(e.getelement(j).getScore() == nbMin){
                    //TODO: faire le temps pour vérifier la deuxième condition
                }
            }
        }
        jElim.changerEtat("éliminé");
        for(int j = 0; j < 20; j++){
            if(e.getelement(j).getEtat().equals("sélectionné")){
                e.getelement(j).changerEtat("gagnant");
            }
        }

                                        // Phase n°2
        ArrayList<String> themeP2 = new ArrayList<>();
        int indexTheme = 0;
        String themeCourantPhase2 = null;
        Boolean verifTheme = false;
        for(int j = 0; j < 6; j++){
            themeCourantPhase2 = thema.selectionnerTheme();
            themeP2.add(themeCourantPhase2);
            thema.enleverTheme(themeCourantPhase2);
        }

        for(int j = 0; j < 20; j++){
            if(e.getelement(j).getEtat().equals("gagnant")){
                aleaType = (int) (Math.random() * 100) % 3;
                System.out.println("aleatype =" + aleaType);
                while(!verifTheme) {
                    System.out.println("Vos choix sont: " + themeP2 + "\nQuel thème choisissez vous pour la prochaine question?");
                    themeCourantPhase2 = sce.nextLine();
                    verifTheme = false;
                    for(int k = 0; k < themeP2.size(); k++){
                        if(themeP2.get(k).equals(themeCourantPhase2)){
                            verifTheme = true;
                            indexTheme = k;
                        }
                    }
                    if(!verifTheme){
                        System.out.println("Ce n'est pas un thème valide, Veuillez réessayer\n");
                    }
                }
                verifTheme = false;
                thema.modifierTheme(themeCourantPhase2);
                System.out.println(thema.getThemeCourant());
                themeP2.remove(indexTheme);
               /* if(aleaType == 0) {
                    System.out.println("--------------------- Type QCM ---------------------");
                    for (TypeQCM ele : a) {
                        if(ele.getTheme().equals(thema.getThemeCourant())){
                            Question q = new Question(numq,ele);
                            bonReponse.add(ele.getRepBonQCM());
                            numq += 1;
                            questi.ajouter(q);
                        }
                    }
                }else if (aleaType == 1){
                    System.out.println("--------------------- Type VF ---------------------");
                    for (TypeVF ele: b) {
                        if(ele.getTheme().equals(thema.getThemeCourant())){
                            Question q = new Question(numq,ele);
                            if(ele.isReponse()){
                                bonReponse.add("vrai");
                            }else{bonReponse.add("faux");}
                            //System.out.println(e.isReponse());
                            numq += 1;
                            questi.ajouter(q);
                        }
                    }
                }else{
                    System.out.println("--------------------- Type RC ---------------------");
                    for (TypeRC ele : c) {
                        if(ele.getTheme().equals(thema.getThemeCourant())){
                            Question q = new Question(numq,ele);
                            bonReponse.add(ele.getReponse());
                            numq += 1;
                            questi.ajouter(q);
                        }
                    }
                }

                jeuPhase2(questi,bonReponse,e.getelement(j),aleaType);
                //e.getelement(j).afficher();
                System.out.println("\n\n");
                */

            }
        }


        //phaseDeJeu(e);
    }
    //phaseDeJeu(e);
//}

    public static void jeuPhase1(ListeQuestions questi,ArrayList<String> bonReponse, Joueur j, int type){
        System.out.println("Joueur " + j.getNom() + " c'est à vous de jouer");
        Scanner sc = new Scanner(System.in);
        String reponse = "null";
        int i = 0;
        if(type == 0){
            //type = QCM
            //On gère la selection de la question par rapport à un niveau donné
            Question<TypeQCM> selec = null;
            while(selec == null) {
                i = (int) (Math.random() * 100 % ListeQuestions.getList().size());
                selec = questi.selectionnerQuestion(1, i);
            }
            Question<TypeQCM> q = new Question<TypeQCM>(1, (TypeQCM) selec.getEnonceQ());
            //On affiche la question, ici dans le désordre pour ne pas que l'utilisateur sache ou est la bonne reponse
            q.afficher();
            //On gère la réponse donné par l'utilisateur
            System.out.println("Réécrivez la réponse que vous trouver juste:");
            reponse = sc.nextLine();
            if(bonReponse.get(i).equals(reponse)){
                j.mAJScore(2);
                System.out.println("Bravo c'est la bonne réponse\n");
            }else{
                System.out.println("dommage la bonne réponse était " + bonReponse.get(i)+ "\n");
            }
        }else if (type == 1){
            //type vrai/faux
            //On gère la selection de la question par rapport à un niveau donné
            Question<TypeVF> selec = null;
            while(selec == null){
                i = (int) (Math.random() * 100 % ListeQuestions.getList().size());
                selec = questi.selectionnerQuestion(1, i);
            }
            Question<TypeVF> q = new Question<TypeVF>(1, (TypeVF) selec.getEnonceQ());
            //On affiche la question
            q.afficher();
            //On gère la réponse donné par l'utilisateur
            System.out.println("écrivez vrai ou faux:");
            reponse = sc.nextLine();
            if(bonReponse.get(i).equals(reponse)){
                j.mAJScore(2);
                System.out.println("Bravo c'est la bonne réponse\n");
            }else{
                System.out.println("dommage la bonne réponse était " + bonReponse.get(i) + "\n");
            }
        }else{
            //type réponse courte
            //On gère la selection de la question par rapport à un niveau donné
            Question<TypeRC> selec = null;
            while(selec == null){
                i = (int) (Math.random() * 100 % ListeQuestions.getList().size());
                selec = questi.selectionnerQuestion(1, i);
            }
            Question<TypeRC> q= new Question<TypeRC>(1, (TypeRC) selec.getEnonceQ());
            //On affiche la question
            q.afficher();
            //On gère la réponse donné par l'utilisateur
            System.out.println("écrivez la bonne réponse");
            reponse = sc.nextLine();
            if(bonReponse.get(i).equals(reponse)){
                j.mAJScore(2);
                System.out.println("Bravo c'est la bonne réponse\n");
            }else{
                System.out.println("dommage la bonne réponse était " + bonReponse.get(i)+ "\n");
            }
        }

    }

    public static void jeuPhase2(ListeQuestions questi,ArrayList<String> bonReponse, Joueur j, int type){

    }
    /*
    public static void phaseDeJeu(EnsJoueurs e) {
        Joueur[] Joueurs = e.selectionnerJoueurs();
        Themes theme;
        premierephase(Joueurs);
        secondephase(Joueurs);
        finalphase(Joueurs);
    }

    public static <T> void premierephase(Joueur[] Joueurs){

        ce que j'essaie maladroitement de faire :
        je selectionne un theme
        ensuite je selectionne la liste de questions correspondants à ce theme
        je selectionne une question de niveau 1 pour la poser à un joueur

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
     */

}
