package question;

import java.util.ArrayList;

public class Themes {
    private ArrayList<String> themes;
    private String themeCourant;

    public Themes() {
        themes = new ArrayList<>();
        initialisationTheme(themes);
    }

    public void initialisationTheme(ArrayList<String> themes){
        themes.add("Animaux");
        themes.add("Astronomie");
        themes.add("Capitale");
        themes.add("Football");
        themes.add("Mathématiques");
        themes.add("Musique");
        themes.add("Sciences");
        themes.add("Sport");
        themes.add("Jeux Vidéo");
        themes.add("Informatique");
    }

    public Themes(String themeCourant) {
        themes = new ArrayList<>();
        this.themeCourant = themeCourant;
    }

    public void modifierTheme(String theme) {
        themeCourant = theme;
    }

    public String selectionnerTheme() {
        String nouveauTheme = themes.get(((int)(Math.random() * 100)) % themes.size());
        return nouveauTheme;
    }

    public void afficher() {
        System.out.println(toString());
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
