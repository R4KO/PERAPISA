package src.question;


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

    public String getTheme(){
        return theme;
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
            output += texteQCM + "\n\n a)" + rep1QCM + "\n b)" + rep2QCM + "\n c)" + rep3QCM + "\n d)" + repBonQCM;
        }else if(i % 4 == 1){
            output += texteQCM + "\n\n a)" + rep1QCM + "\n b)" + rep2QCM + "\n c)" + repBonQCM + "\n d)" + rep3QCM;
        }else if(i % 4 == 2){
            output += texteQCM + "\n\n a)" + rep1QCM + "\n b)" + repBonQCM + "\n c)" + rep2QCM + "\n d)" + rep3QCM;
        }else{
            output += texteQCM + "\n\n a)" + repBonQCM + "\n b)" + rep1QCM + "\n c)" + rep2QCM + "\n d)" + rep3QCM;
        }
        output += "\n";
        return output;
    }

    public String getRepBonQCM() {
        return repBonQCM;
    }
    public String getRep1QCM() {
        return rep1QCM;
    }

    public String getRep2QCM() {
        return rep2QCM;
    }

    public String getRep3QCM() {
        return rep3QCM;
    }

    public String getTexteQCM() {
        return texteQCM;
    }
    
}
