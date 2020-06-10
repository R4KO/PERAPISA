package src.question;

import java.util.Scanner;

public class TypeRC extends TypeQuestion {
    private String reponse;

    public TypeRC(Scanner sc) {
        theme = sc.nextLine();
        niveau = sc.nextInt();
        sc.nextLine(); // important

        proposition = sc.nextLine();
        reponse = sc.nextLine();
    }

    public TypeRC(Scanner sc, String line) {
        theme = line;
        niveau = sc.nextInt();
        sc.nextLine(); // important

        proposition = sc.nextLine();
        reponse = sc.nextLine();
    }

    public String getTheme(){
        return theme;
    }

    @Override
    public void afficher() {
        System.out.println(toString());
    }

    public String getReponse() {
        return reponse;
    }
}
