package question;

import java.util.ArrayList;

public class Themes {
    private ArrayList<String> themes;
    private String themeCourant;

    public Themes() {
        themes = new ArrayList<>();
        initialisationTheme();
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
