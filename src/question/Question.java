package question;

public class Question <T>{
    private int numQ;
    private String themeQ;
    private int nivQ;
    private T enonceQ;


    public Question(int numQ, String themeQ, int nivQ, T enonceQ) {
        this.numQ = numQ;
        this.themeQ = themeQ;
        this.nivQ = nivQ;
        this.enonceQ = enonceQ;
    }

    public void afficher(T enonceQ) {
        System.out.println(toString());
    }

    @Override
    public String toString(){
        String output = "";
        output += "Niveau = " + nivQ + "\n" + enonceQ.toString();
        return output;
    }
}
