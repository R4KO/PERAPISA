package players;

public class Joueur implements Comparable<Joueur> {
    private static int NUMERO = 100;
    private int numero;
    private String nom;
    private int score;
    private String etat;

    public Joueur() {
        numero = NUMERO;
        NUMERO += 10;
        etat = "en attente";
    }

    public void saisir(String nom) {
        this.nom = nom;
    }

    public void mAJScore(int phase) {
        // On récupère directement le numéro de la phase en paramètre et on incrémente le bon nombre grâce au tableau statique de la class EnsJoueurs
        score += EnsJoueurs.scores[phase - 1];
    }

    public void changerEtat(String etat) {
        this.etat = etat;
    }

    public void afficher() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String output = "";
        output += "Joueur " + numero + "\n"
                + nom + "\n"
                + "Score: " + score + "\n"
                + etat + "\n";
        return output;
    }

    public String getEtat() {
        return etat;
    }

    public String getNom() {
        return nom;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Joueur joueur) {
        return Integer.toString(joueur.getScore()).compareTo(Integer.toString(score));
    }
}