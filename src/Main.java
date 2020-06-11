import players.*;
import question.*;

import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    /// TODO: LinkedLists
    static ArrayList<TypeQCM> a = new ArrayList<>(); // QCM
    static ArrayList<TypeVF> b = new ArrayList<>(); // Vrai/Faux
    static ArrayList<TypeRC> c = new ArrayList<>(); // Répnses courtes

    public static void main(String[] args) throws FileNotFoundException {

        String path = "assets/";


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
        themes.initialisationTheme();

        // Phase 1
        System.out.println("\n---------------------Phase 1---------------------\n");
        jeu(e, joueurs, themes);

        System.out.println("Le joueur " + joueurs[3].getNom() + " est le dernier.\nIl est donc éliminé");
        System.out.println("Le joueur " + joueurs[0].getNom() + " est le premier.\nIl gagne donc le statut de gagnant");
        // On donne le statut de gagnant
        joueurs[0].changerEtat("gagnant");
        joueurs[3].changerEtat("éliminé");

        // On retire le dernier élément
        joueurs = Arrays.copyOf(joueurs, joueurs.length-1);

        // Affichage des joueurs
        for (Joueur j : joueurs) {
            j.afficher();
        }

        // Phase 2
        System.out.println("\n---------------------Phase 2---------------------\n");
        jeu(e, joueurs, themes);

        System.out.println("\nLe joueur " + joueurs[2].getNom() + " est le dernier.\nIl est donc éliminé");
        System.out.println("\nLe joueur " + joueurs[0].getNom() + " est le premier.\nIl gagne donc le statut de gagnant");
        // On donne le statut de gagnant
        joueurs[0].changerEtat("gagnant");
        joueurs[2].changerEtat("éliminé");

        // On retire le dernier élément
        joueurs = Arrays.copyOf(joueurs, joueurs.length-1);

        // Affichage des joueurs
        for (Joueur j : joueurs) {
            j.afficher();
        }

        // Phase 3
        System.out.println("\n---------------------Phase 3---------------------\n");
        jeu(e, joueurs, themes);

        System.out.println("\n---------------------FIN DU JEU---------------------\n");
        System.out.println("Le joueur " + joueurs[1].getNom() + " est le perdant");
        System.out.println("FÉLICITATIONS À " + joueurs[0].getNom() + " QUI GAGNE LE JEU");

        // donner les status
        joueurs[0].changerEtat("super-gagnant");
        joueurs[1].changerEtat("éliminé");

        System.out.println("\n---------------------Liste de tous les joueurs---------------------\n");
        // Affichage de l'ensemble des joueurs
        e.afficher();
    }

    public static void jeu(EnsJoueurs e, Joueur[] j, Themes themes) {
        //tableau de tous les types de questions
        String[] types = {a.get(0).getClass().getSimpleName(), b.get(0).getClass().getSimpleName(), c.get(0).getClass().getSimpleName()};
        // tableau contenant les ArrayLists de question
        ArrayList[] typesQuestion = {a, b, c};
        // Types de questions qui seront posées
        ArrayList<TypeQuestion> selected = typesQuestion[new Random().nextInt(typesQuestion.length)];
        String typeSelected = selected.get(0).getClass().getSimpleName();


        ListeQuestions questions = new ListeQuestions();


        System.out.println("Type sélectionné : " + typeSelected + "\n");
        System.out.println("------------------------------------------");
        //System.out.println("Thème courant : " + themes.getThemeCourant());

        //ajouterQuestions(selected, themes, e, questions);

        //System.out.println("Nombre de questions: " + questions.nombreDeQuestions());
        //questions.afficher();
        switch (e.phaseDeJeu()) {
            case 1:
                for (Joueur joueur : j) {
                    System.out.println("\n\nnAu tour du joueur " + joueur.getNom() + "\n\n");
                    // changer de thème
                    themes.selectionnerTheme();
                    ajouterQuestions(selected, themes, e, questions);
                    //System.out.println("Nombre de questions: " + questions.nombreDeQuestions());
                    poserQuestion(e.phaseDeJeu(), questions.selectionnerQuestion(), joueur);
                }

                // Trier le tableau de joueur
                Arrays.sort(j);

                // Afficher les joueurs
                for (Joueur joueur : j) {
                    joueur.afficher();
                }

                // Phase suivante
                e.phaseSuivante();
                break;
            case 2:
                Scanner sc = new Scanner(System.in);
                // 2 tours de boucle
                for (int i = 0; i < 2; i++) {
                    for (Joueur joueur : j) {
                        System.out.println("\n\nnAu tour du joueur " + joueur.getNom() + "\n\n");
                        System.out.println("Thèmes disponibles: ");

                        // Afficher les thèmes disponibles
                        themes.afficher();

                        System.out.print("Choissisez un thème: ");

                        String ans = sc.next();
                        // Si le thème entré n'est pas valide
                        while (!themes.contient(ans)) {
                            System.out.print("Veuillez entrer un thème valide: ");
                            ans = sc.next();
                        }

                        // changer de thème
                        themes.modifierTheme(ans);
                        ajouterQuestions(selected, themes, e, questions);
                        //System.out.println("Nombre de questions: " + questions.nombreDeQuestions());
                        poserQuestion(e.phaseDeJeu(), questions.selectionnerQuestion(), joueur);
                    }

                    Arrays.sort(j);
                }

                // Trier le tableau de joueur
                Arrays.sort(j);

                // Afficher les joueurs
                for (Joueur joueur : j) {
                    joueur.afficher();
                }

                // Phase suivante
                e.phaseSuivante();
                break;
            case 3:
                // On récupère tous les thèmes
                themes.initialisationTheme();
                // On vide le tableau des thèmes déjà passés
                themes.viderThemes();

                // 3 tours de boucles
                for (int i = 0; i < 2; i++) {
                    for (Joueur joueur : j) {
                        System.out.println("\n\nnAu tour du joueur " + joueur.getNom() + "\n\n");
                        // changer de thème
                        themes.selectionnerTheme();
                        ajouterQuestions(selected, themes, e, questions);
                        //System.out.println("Nombre de questions: " + questions.nombreDeQuestions());
                        poserQuestion(e.phaseDeJeu(), questions.selectionnerQuestion(), joueur);
                    }
                }

                // Trier le tableau de joueur
                Arrays.sort(j);

                // Afficher les joueurs
                for (Joueur joueur : j) {
                    joueur.afficher();
                }

                // Phase suivante
                e.phaseSuivante();
                break;
        }

    }

    // Fonction pour ajouter les fonctions dans la liste de questions par rapport au thème et à la phase
    public static void ajouterQuestions(ArrayList<TypeQuestion> selected, Themes themes, EnsJoueurs e, ListeQuestions questions) {
        // Vider la liste de questions
        questions.viderQuestions();

        // Ajouteur les bonnes questions dans la liste peu importe le type
        for (int i = 0; i < selected.size(); i++) {
            TypeQuestion t = selected.get(i);

            // Le thème de la question doit correspondre au thème sélectionné et le niveau doit correspondre à la phase
            if (t.getTheme().toUpperCase().equals(themes.getThemeCourant().toUpperCase()) && t.getNiveau() == e.phaseDeJeu()) {
                questions.ajouter(new Question(i, t));
            }
        }
    }

    public static void poserQuestion(int phase, Question q, Joueur j) {
        Scanner sc = new Scanner(System.in);

        q.afficher();

        System.out.print("Réponse : ");

        String reponse = sc.nextLine();

        if (q.saisir(reponse)) {
            System.out.println("Bonne réponse");
            j.mAJScore(phase); // La méthode mAJScore récpurère le bon nombre de points grâce au numéro de la phase
        }else {
            System.out.println("Mauvaise réponse");
        }
        System.out.println();
        System.out.println();
    }
}