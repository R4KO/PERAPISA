package players;

import java.util.Vector;

public class EnsJoueurs implements Phase {
    static final int[] scores = {2, 3, 5};
    private Vector<Joueur> joueurs;
    private int phaseCourante;

    public EnsJoueurs() {
        joueurs = new Vector<>();
        phaseCourante = 1;
    }

    public Joueur selectionnerJoueur() {
        // nombre aléatoire
        Joueur j =  joueurs.elementAt((int) (Math.random() * 100) % joueurs.size());

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

    @Override
    public String toString() {
        String output = "";
        for (Joueur j : joueurs) {
            output += j.toString() + "\n";
        }
        return output;
    }

    @Override
    public int phaseDeJeu() {
        return phaseCourante;
    }

    public void phaseSuivante() {
        phaseCourante++;
    }

    @Override
    public Joueur[] selectionnerJoueurs() {
        return new Joueur[] {selectionnerJoueur(), selectionnerJoueur(), selectionnerJoueur(), selectionnerJoueur()};
    }
}
