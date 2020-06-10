package question;

public class Question <T extends TypeQuestion>{
    private int numQ;
    private String themeQ;
    private int nivQ;
    private T enonceQ;


    public Question(int numQ, T enonceQ) {
        this.numQ = numQ;
        this.themeQ = enonceQ.theme;
        this.nivQ = enonceQ.niveau;
        this.enonceQ = enonceQ;
    }

    @Override
    public String toString(){
        return enonceQ.toString();
    }

    public void afficher() {
        System.out.println(toString() + "\n");
    }

    // Fonction qui vérifie si la réponse saisie est une bonne réponse
    public boolean saisir(String reponse) {
        return enonceQ.verifierReponse(reponse);
    }
}
