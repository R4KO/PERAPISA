package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Themes {
    private String[] themes;
    private String themeCourant;
    private ArrayList<String> themesPasses;

    public Themes() {
        themesPasses = new ArrayList<>();
        themeCourant = "";
    }

    public void initialisationTheme(){
        themes = new String[]{"animaux", "astronomie", "capitale", "football", "mathématiques", "musique", "sciences", "sport", "jeuxvidéo", "informatique"};
    }


    public void modifierTheme(String designation) {
        /// TODO: trouver un sens à cette méthode
        // i: numéro du thème dans le tableau
        //
        themeCourant = designation;
    }

    public String selectionnerTheme() {
        String nouveauTheme = "";
        if (themeCourant.equals("")) {
            int indice = new Random().nextInt(themes.length);
            nouveauTheme = themes[indice];
        }
        else {
            nouveauTheme = themes[(Arrays.asList(themes).indexOf(themeCourant) + 1) % themes.length];
            if (themesPasses.contains(nouveauTheme)) {
                modifierTheme(nouveauTheme);
                selectionnerTheme();
            }
        }
        modifierTheme(nouveauTheme);
        themesPasses.add(nouveauTheme);

        return nouveauTheme;
    }

    public void afficher() {
        System.out.println(toString());
    }

    public String getThemeCourant() {
        return themeCourant;
    }
    @Override
    public String toString() {
        String output = "";
        for (String s : themes) {
            output += s + "\n";
        }
        return output;
    }

}
