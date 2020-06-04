package question;

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

    @Override
    public void afficher() {
        System.out.println(toString());
    }
}
