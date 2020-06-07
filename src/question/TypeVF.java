package question;

import java.util.Scanner;

public class TypeVF extends TypeQuestion {
    private boolean reponse;

    public TypeVF(Scanner sc) {
        theme = sc.nextLine();
        niveau = sc.nextInt();
        sc.nextLine();

        proposition = sc.nextLine();

        if (sc.nextLine().toUpperCase().equals("VRAI")) {
            reponse = true;
        }
        else {
            reponse = false;
        }
    }

    @Override
    public boolean verifierReponse(String reponse) {
        return reponse.equals(this.reponse);
    }

    @Override
    public void afficher() {
        System.out.println(toString());
    }
}
