package players;

import question.*;

import java.util.Objects;
import java.util.Vector;

public class EnsJoueurs implements Phase {
    private Vector<Joueur> joueurs;
    int phase=1;

    public EnsJoueurs() {
        joueurs = new Vector<>();
    }

    public Joueur selectionnerJoueur() {
        // nombre aléatoire
        Joueur j =  joueurs.elementAt((int) (Math.random() * 100) % joueurs.size());
        /*
        if (!j.getEtat().equals("sélectionné")) {
            // Sélectionné donc change d'état
            j.changerEtat("sélectionné");
            return j;
        }
        else {
            selectionnerJoueur();
        }
        */

        if (j.getEtat().equals("sélectionné")) {
            selectionnerJoueur();
        }
        else {
            j.changerEtat("sélectionné");
            return j;
        }
        return selectionnerJoueur();
    }

    public void creer() {
        for (int i = 0; i < 20; i++) {
            char ch = (char) ('a' + i);
            Joueur j = new Joueur();
            j.saisir(Character.toString(ch).toUpperCase());
            joueurs.add(j);
        }
    }

    public void afficher() {
        System.out.println(toString());
    }
    public Joueur getelement(int x){
    
        return joueurs.elementAt(x);
    
    }
    

    @Override
    public String toString() {
        String output = "";
        for (Joueur j : joueurs) {
            output += j.toString() + "\n";
        }
        return output;
    }





    @Override
    public Joueur[] selectionnerJoueurs() {
        return new Joueur[]{selectionnerJoueur(), selectionnerJoueur(), selectionnerJoueur(), selectionnerJoueur()};
    }
}
