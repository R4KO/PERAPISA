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
    public boolean verifierReponse(String reponse) {
        return reponse.equals(this.reponse);
    }

    @Override
    public void afficher() {
        System.out.println(toString());
    }
}
