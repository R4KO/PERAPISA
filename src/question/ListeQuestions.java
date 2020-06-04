package question;

import java.util.ArrayList;

public class ListeQuestions {
    private ArrayList<Question> list;

    public ListeQuestions() {
        list = new ArrayList<>();
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

    public Question selectionnerQuestion() {
        /// TODO: séletionner la question
        return null;
    }
}
