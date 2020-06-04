package question;


import java.util.Scanner;

public class TypeQCM {
    private String texteQCM;            //La question
    private String rep1QCM;             //réponse n°1
    private String rep2QCM;             //réponse n°2
    private String rep3QCM;             //réponse n°3
    private String repBonQCM;           //réponse n°4 et bonne réponse


    //Constructeur avec paramètres
    public TypeQCM(Scanner sc) {
        String reponse = null;

        this.texteQCM = sc.nextLine();
        this.repBonQCM = sc.nextLine();

        reponse = sc.nextLine();
        if(!reponse.equals(this.repBonQCM)){
            this.rep1QCM = reponse;

            reponse = sc.nextLine();
            if(!reponse.equals(this.repBonQCM)) {
                this.rep2QCM = reponse;

                reponse = sc.nextLine();
                if (!reponse.equals(this.repBonQCM)) {
                    this.rep3QCM = reponse;
                }else{
                    this.rep3QCM = sc.nextLine();
                }
            }else{
                this.rep2QCM = sc.nextLine();
                this.rep3QCM = sc.nextLine();
            }
        }else{
            this.rep1QCM = sc.nextLine();
            this.rep2QCM = sc.nextLine();
            this.rep3QCM = sc.nextLine();
        }
    }


    public void afficher() {          //Fonction d'affichage des questions et réponses de façon aléatoire
        System.out.println(toString());
    }

    @Override
    public String toString() {          //Fonction retourne String
        int i;
        String output;
        i = (int) (Math.random() * 100);

        if (i % 4 == 0) {
            output = texteQCM + "\n\n" + rep1QCM + "\t\t" + rep2QCM + "\n" + rep3QCM + "\n" + repBonQCM;
        }else if(i % 4 == 1){
            output = texteQCM + "\n\n" + rep1QCM + "\t\t" + rep2QCM + "\n" + repBonQCM + "\n" + rep3QCM;
        }else if(i % 4 == 2){
            output = texteQCM + "\n\n" + rep1QCM + "\t\t" + repBonQCM + "\n" + rep2QCM + "\n" + rep3QCM;
        }else{
            output = texteQCM + "\n\n" + repBonQCM + "\t\t" + rep1QCM + "\n" + rep2QCM + "\n" + rep3QCM;
        }
        return output;
    }
}
