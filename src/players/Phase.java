package players;

public interface Phase {
    int phaseDeJeu = 1;
    abstract public Joueur[] selectionnerJoueurs();
}
