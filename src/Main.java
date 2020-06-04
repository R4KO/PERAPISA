import players.EnsJoueurs;
import players.Joueur;
import question.TypeQCM;
import question.Question;
import question.TypeRC;
import question.TypeVF;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "assets/";

        ArrayList<TypeQCM> a = new ArrayList<>(); // Questions QCM
        ArrayList<TypeVF> b = new ArrayList<>(); // Questions Vrai/Faux
        ArrayList<TypeRC> c = new ArrayList<>(); // Questions Réponse courte


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
            if (line.equals("vf")){
                TypeVF q = new TypeVF(sc);
                b.add(q);
                //System.out.println(line);
            }
        }

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


        // Création de l'ensemble des joueurs
        EnsJoueurs e = new EnsJoueurs();
        e.creer();
        e.afficher();

        System.out.println("---------------------Sélection des joueurs---------------------");
        for (Joueur j : e.selectionnerJoueurs()) {
            j.afficher();
        }

    }
}
