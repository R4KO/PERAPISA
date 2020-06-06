package players;

public interface Phase {
    //int phaseDeJeu = 1;
    abstract public void phaseDeJeu(int x);
    abstract public Joueur[] selectionnerJoueurs();
}
