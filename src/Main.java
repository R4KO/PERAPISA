import players.EnsJoueurs;
import question.TypeQCM;
import question.Question;
import question.TypeRC;
import question.TypeVF;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //System.out.println("Hello World");

        String path = "assets/";

        ArrayList<TypeQCM> a = new ArrayList<>();
        ArrayList<TypeVF> b = new ArrayList<>();
        ArrayList<TypeRC> c = new ArrayList<>();


        // Initialisation des questions
        File f = new File(path + "quizz.txt");
        Scanner sc = new Scanner(f);

        String line =null;

        while (sc.hasNext()) {
            line = sc.nextLine();

            // Récup les RC
            if (line.equals("rc")){
                TypeRC q = new TypeRC(sc);
                c.add(q);
                //System.out.println(line+ "\n");
            }



            // Récup les QCM
            if (line.equals("qcm")){
                TypeQCM q = new TypeQCM(sc);
                a.add(q);
            }

            // Récup les VF
            if(line.equals("vf")){
                TypeVF q = new TypeVF(sc);
                b.add(q);
                //System.out.println(line);
            }
        }
        /*
        // Création de l'ensemble des joueurs
        EnsJoueurs e = new EnsJoueurs();
        e.creer();
        e.afficher();

        System.out.println("---------------------Sélection d'un joueur---------------------");

        e.selectionnerJoueur().afficher();

        System.out.println("---------------------Nouvel ensemble---------------------");

        e.afficher();
        */

        //Création d'une question
        //TypeQCM q = new TypeQCM("a","b","c","d");
        //Question e = new Question("a",);


        System.out.println("--------------------- Affichage des QCM---------------------");
        for (TypeQCM e: a) {
            e.afficher();
        }

        System.out.println("---------------------Affichage des Vrai/Faux---------------------");
        for (TypeVF e: b) {
            e.afficher();
            System.out.println();
        }

        System.out.println("---------------------Affichage des Réponses courtes---------------------");
        for (TypeRC e : c) {
            e.afficher();
            System.out.println();
        }
    }
}
