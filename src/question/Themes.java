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
        themes.add("animaux");
        themes.add("astronomie");
        themes.add("capitale");
        themes.add("football");
        themes.add("mathématiques");
        themes.add("musique");
        themes.add("sciences");
        themes.add("sport");
        themes.add("jeuxvidéo");
        themes.add("informatique");
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
        modifierTheme(nouveauTheme);
        return nouveauTheme;
    }

    public String getThemeCourant(){
        return themeCourant;
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
