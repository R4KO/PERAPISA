package question;


import java.util.Scanner;

public class TypeQCM extends TypeQuestion{

    private String texteQCM;            //La question
    private String rep1QCM;             //réponse n°1
    private String rep2QCM;             //réponse n°2
    private String rep3QCM;             //réponse n°3
    private String repBonQCM;           //réponse n°4 et bonne réponse


    //Constructeur avec paramètres
    public TypeQCM(Scanner sc) {
        theme = sc.nextLine();
        niveau = sc.nextInt();
        sc.nextLine();

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

    @Override
    public boolean verifierReponse(String reponse) {
        // Fonction qui vérifie si la réponse est la bonne
        return reponse.equals(repBonQCM);
    }

    @Override
    public void afficher() {          //Fonction d'affichage des questions et réponses de façon aléatoire
        System.out.println(toString());
    }

    @Override
    public String toString() {          //Fonction retourne String
        String output = "";

        output += super.toString();

        int i = (int) (Math.random() * 100);

        if (i % 4 == 0) {
            output += texteQCM + "\n\n" + rep1QCM + "\n" + rep2QCM + "\n" + rep3QCM + "\n" + repBonQCM;
        }else if(i % 4 == 1){
            output += texteQCM + "\n\n" + rep1QCM + "\n" + rep2QCM + "\n" + repBonQCM + "\n" + rep3QCM;
        }else if(i % 4 == 2){
            output += texteQCM + "\n\n" + rep1QCM + "\n" + repBonQCM + "\n" + rep2QCM + "\n" + rep3QCM;
        }else{
            output += texteQCM + "\n\n" + repBonQCM + "\n" + rep1QCM + "\n" + rep2QCM + "\n" + rep3QCM;
        }
        output += "\n";
        return output;
    }
}
