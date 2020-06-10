package question;

import java.util.ArrayList;
import java.util.Random;

public class Themes {
    private ArrayList<String> themes;
    private String themeCourant;

    public Themes() {
        themes = new ArrayList<>();
    }

    public void initialisationTheme(){
        this.themes.add("Animaux");
        this.themes.add("Astronomie");
        this.themes.add("Capitale");
        this.themes.add("Football");
        this.themes.add("Mathématiques");
        this.themes.add("Musique");
        this.themes.add("Sciences");
        this.themes.add("Sport");
        this.themes.add("Jeux Vidéo");
        this.themes.add("Informatique");
    }

    public Themes(String themeCourant) {
        themes = new ArrayList<>();
        this.themeCourant = themeCourant;
    }

    public void modifierTheme(String designation) {
        /// TODO: trouver un sens à cette méthode
        // i: numério du thème dans le tableau
        //
        themeCourant = designation;
    }

    public String selectionnerTheme() {
        String nouveauTheme = themes.get(new Random().nextInt(themes.size()));
        modifierTheme(nouveauTheme);

        // retirer le thème de la liste de thèmes
        themes.remove(nouveauTheme);
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
