import players.EnsJoueurs;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //System.out.println("Hello World");

        /*
        String path = "assets/";

        // Initialisation des questions
        File f = new File(path + "quizz.txt");
        Scanner sc = new Scanner(f);

        // Afficher les V/F
        while (sc.hasNext()) {
            String line = sc.nextLine();
            if (line.equals("rc"))
                break;
            System.out.println(line);
        }

        // Afficher les RC
        while (sc.hasNext()) {
            String line = sc.nextLine();
            if (line.equals("qcm"))
                break;
            System.out.println(line);
        }

        // Afficher les QCM
        while (sc.hasNext()) {
            String line = sc.nextLine();
            System.out.println(line);
        }
        */

        // Création de l'ensemble des joueurs
        EnsJoueurs e = new EnsJoueurs();
        e.creer();
        e.afficher();

        System.out.println("---------------------Sélection d'un joueur---------------------");

        e.selectionnerJoueur().afficher();

        System.out.println("---------------------Nouvel ensemble---------------------");

        e.afficher();

    }
}
