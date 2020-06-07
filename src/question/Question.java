package question;

import java.util.Scanner;

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

    public <T> String bonneReponse(T question) {
        if (question instanceof TypeQCM) {
            TypeQCM qcmquestion = new TypeQCM((Scanner) question);
            return qcmquestion.getRepBonQCM();
        } else if (question instanceof TypeRC) {
            TypeRC rcquestion = new TypeRC((Scanner) question);
            return rcquestion.getReponse();
        } else if (question instanceof TypeVF) {
            TypeVF vfquestion = new TypeVF((Scanner) question);
            if (vfquestion.isReponse()) {
                return "Vrai";
            } else {
                return "Faux";
            }
        }
        return null;
    }
}
