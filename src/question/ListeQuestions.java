package question;

import java.util.ArrayList;
import java.util.Random;

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
        Question q = list.get(new Random().nextInt(list.size()));
        list.remove(q);
        return q;
    }

    public int nombreDeQuestions() {
        return list.size();
    }

    public void viderQuestions() {
        list.clear();
    }
}
