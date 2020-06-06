package players;

import question.ListeQuestions;
import question.Question;
import question.Themes;

import java.util.Vector;

public class EnsJoueurs implements Phase {
    private Vector<Joueur> joueurs;
    int phase=1;

    public EnsJoueurs() {
        joueurs = new Vector<>();
    }

    public Joueur selectionnerJoueur() {
        // nombre aléatoire
        Joueur j =  joueurs.elementAt((int) (Math.random() * 100) % joueurs.size());
        /*
        if (!j.getEtat().equals("sélectionné")) {
            // Sélectionné donc change d'état
            j.changerEtat("sélectionné");
            return j;
        }
        else {
            selectionnerJoueur();
        }
        */

        if (j.getEtat().equals("sélectionné")) {
            selectionnerJoueur();
        }
        else {
            j.changerEtat("sélectionné");
            return j;
        }
        return selectionnerJoueur();
    }

    public void creer() {
        for (int i = 0; i < 20; i++) {
            char ch = (char) ('a' + i);
            Joueur j = new Joueur();
            j.saisir(Character.toString(ch).toUpperCase());
            joueurs.add(j);
        }
    }

    public void afficher() {
        System.out.println(toString());
    }
    public Joueur getelement(int x){
    
        return joueurs.elementAt(x);
    
    }
    

    @Override
    public String toString() {
        String output = "";
        for (Joueur j : joueurs) {
            output += j.toString() + "\n";
        }
        return output;
    }


    @Override
    public void phaseDeJeu(int x) {
        Joueur[] Joueurs = selectionnerJoueurs();
        Themes theme;
        switch (x){
            case 1:
                premierephase(x,Joueurs);
                break;
            case 2:
                secondephase(x,Joueurs);
                break;
            case 3:
                finalphase(x,Joueurs);
                break;
        }

    }

    public void premierephase(int x,Joueur[] Joueurs){

        /*ce que j'essaie maladroitement de faire :
        je selectionne un theme
        ensuite je selectionne la liste de questions correspondants à ce theme
        je selectionne une question de niveau 1 pour la poser à un joueurje
         */
        Themes theme = new Themes();
        theme.selectionnerTheme();
        ListeQuestions questions = new ListeQuestions(theme);
        for(int i=0;i<Joueurs.length;i++){
            Question q = questions.selectionnerQuestion(1);
            q.afficher();

            //TODO : gérer les points selon bonne ou mauvaise réponse
        }
        x++;
        phaseDeJeu(x);
    }

    public void secondephase(int x,Joueur[] Joueurs){

    }

    public void finalphase(int x,Joueur[] Joueurs){

    }

    @Override
    public Joueur[] selectionnerJoueurs() {
        return new Joueur[]{selectionnerJoueur(), selectionnerJoueur(), selectionnerJoueur(), selectionnerJoueur()};
    }
}
