import players.*;
import question.*;

import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "assets/";

        /// TODO: LinkedLists
        ArrayList<TypeQCM> a = new ArrayList<>(); // QCM
        ArrayList<TypeVF> b = new ArrayList<>(); // Vrai/Faux
        ArrayList<TypeRC> c = new ArrayList<>(); // Répnses courtes


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


        //tableau de tous les types de questions
        String[] types = {a.get(0).getClass().getSimpleName(), b.get(0).getClass().getSimpleName(), c.get(0).getClass().getSimpleName()};
        // tableau contenant les ArrayLists de question
        ArrayList[] typesQuestion = {a, b, c};
        // Types de questions qui seront posées
        ArrayList<TypeQuestion> selected = typesQuestion[new Random().nextInt(typesQuestion.length)];
        String typeSelected = selected.get(0).getClass().getSimpleName();

        /*
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

         */


        // Création de l'ensemble des joueurs
        EnsJoueurs e = new EnsJoueurs();
        e.creer();
        System.out.println("---------------------Sélection des joueurs---------------------");
        Joueur[] joueurs = e.selectionnerJoueurs();
        //e.afficher();

        for (Joueur j : joueurs) {
            j.afficher();
        }

        // Choisir un thème
        Themes themes = new Themes();

        ListeQuestions questions = new ListeQuestions();

        themes.initialisationTheme();
        themes.selectionnerTheme();

        System.out.println("Type sélectionné : " + typeSelected);
        System.out.println("Thème courant : " + themes.getThemeCourant());

        // Ajouteur les bonnes questions dans la liste peu importe le type
        for (int i = 0; i < selected.size(); i++) {
            TypeQuestion t = selected.get(i);
            // Le thème de la question doit correspondre au thème sélectionné et le niveau doit correspondre à la phase
            if (t.getTheme().toUpperCase().equals(themes.getThemeCourant().toUpperCase()) && t.getNiveau() == e.phaseDeJeu()) {
                questions.ajouter(new Question(i, t));
            }
        }

        questions.afficher();
    }
}