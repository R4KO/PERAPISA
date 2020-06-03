package players;

import java.util.Vector;

public class EnsJoueurs {
    private Vector<Joueur> joueurs;

    public EnsJoueurs() {
        joueurs = new Vector<>();
    }

    public Joueur selectionnerJoueur() {
        // nombre aléatoire
        Joueur j =  joueurs.elementAt((int) (Math.random() * 100) % joueurs.size());
        // Sélectionné donc change d'état
        j.changerEtat("sélectionné");
        return j;
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

}
