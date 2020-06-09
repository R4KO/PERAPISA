package question;

import java.util.ArrayList;

public class ListeQuestions {
    private static ArrayList<Question> list;

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

    public static ArrayList<Question> getList(){
        return list;
    }

    public void ajouter(Question q) {
        list.add(q);
    }

    public void supprimer(Question q) {
        list.remove(q);
    }

    public Question selectionnerQuestion(int niveau, int i) {
        if(list.get(i).getNiveau() == niveau){
            return list.get(i);
        }
        return null;
    }
}
