package src.question;


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

    public T getEnonceQ(){
        return this.enonceQ;
    }

    @Override
    public String toString(){
        String output = "";
        output += enonceQ.toString();
        return output;
    }

    public int getNiveau(){
        return this.nivQ;
    }

    public void afficher() {
        System.out.println(toString());
    }
    /*
    public <T> String bonneReponse(T question) {
        System.out.println(question instanceof TypeQCM);
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

    public <TypeQCM> String bonRepQCM(TypeQCM question){
        question.TypeQCM qcmquestion = new question.TypeQCM((Scanner) question);

        System.out.println("b");
        return qcmquestion.getRepBonQCM();
    }
    */
}
