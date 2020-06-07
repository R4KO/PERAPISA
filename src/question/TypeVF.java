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

    public String getTheme(){
        return theme;
    }

    @Override
    public void afficher() {
        System.out.println(toString());
    }

    public boolean isReponse() {
        return reponse;
    }

}
