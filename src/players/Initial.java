/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.players;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import src.question.ListeQuestions;
import src.question.Question;
import src.question.Themes;
import src.question.TypeQCM;
import src.question.TypeRC;
import src.question.TypeVF;

/**
 *
 * @author samot
 */

public class Initial {

        public static ArrayList<TypeQCM> a = new ArrayList<>(); // QCM
        public static ArrayList<TypeVF> b = new ArrayList<>(); // Vrai/Faux
        public static ArrayList<TypeRC> c = new ArrayList<>(); // Répnses courtes
        public static int aleaType;
        public static ArrayList<String> enonceQuestion = new ArrayList<>();
        public static ArrayList<String> bonReponse = new ArrayList<>();
        public static ArrayList<String> autreRepQcm = new ArrayList<>();
        
    
    public Initial() throws FileNotFoundException {
        
        String path = "build/classes/assets/";
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
        
        
        
    }
    
    public int rand(){
    
         aleaType = (int) (Math.random() * 100) % 3;
         return aleaType;
    }
    
    public ListeQuestions remplirQuestions(){
    

        //on déclare un numéro de question qui sera incrémenter
        int numq = 0;
        aleaType = 1;//ici ajouter pour les tests
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
                    enonceQuestion.add(e.getTexteQCM());
                    bonReponse.add(e.getRepBonQCM());
                    autreRepQcm.add(e.getRep1QCM());
                    autreRepQcm.add(e.getRep2QCM());
                    autreRepQcm.add(e.getRep3QCM());
                    
                    numq += 1;
                    questi.ajouter(q);
                }
            }
        }else if (aleaType == 1){
            System.out.println("--------------------- Type VF ---------------------");
            for (TypeVF e: b) {
                if(e.getTheme().equals(thema.getThemeCourant())){
                    Question q = new Question(numq,e);
                    enonceQuestion.add(e.getProposition()); // correspond à la question vf que l on veut
                    if(e.isReponse()){
                        bonReponse.add("vrai");
                        autreRepQcm.add("faux");
                    }else{
                        bonReponse.add("faux");
                        autreRepQcm.add("vrai");
                    
                    }
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
        
    return questi;
    
    }
    
    
    
}
