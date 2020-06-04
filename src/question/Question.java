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
        String output = "";
        output += "Niveau = " + nivQ + "\n" + "Thème: " + "\n" + enonceQ.toString();
        return output;
    }

    public void afficher() {
        System.out.println(toString());
    }
}
