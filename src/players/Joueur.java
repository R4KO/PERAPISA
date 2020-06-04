package players;

public class Joueur {
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

    public void mAJScore(int number) {
        score += number;
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
}
