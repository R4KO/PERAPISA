package question;

import java.util.ArrayList;

public class ListeQuestions {
    private ArrayList<Question> list;

    public ListeQuestions() {
        list = new ArrayList<>();
    }

    public ListeQuestions(Themes themes){
        list = new ArrayList<Question>();
    }

    public void afficher() {
        for (Question q : list) {
            q.afficher();
        }
    }

    public void ajouter(Question q) {
        list.add(q);
    }

    public void supprimer(Question q) {
        list.remove(q);
    }

    public Question selectionnerQuestion(int niveaux) {
        /// TODO: séletionner la question
        return null;
    }
}
