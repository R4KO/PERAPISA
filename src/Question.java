import java.util.List;

public class Question<T> {
    protected Theme theme;

    public Question(String type,int difficulte){
        this.theme.SelectionnerTheme();
        if(type.equals("QCM"))
        {
            T question =  (T) new QCM();
        }
        else if(type.equals("VF"))
        {
            T question =  (T) new VraiFaux();
        }
        else{
            T question =  (T) new ReponseCourte();
        }
    }
}
