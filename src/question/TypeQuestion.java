package question;

abstract public class TypeQuestion {
    protected String theme;
    protected int niveau;
    protected String proposition;

    abstract public void afficher();
    @Override
    public String toString() {
        String output = "";
        output += proposition;
        return output;
    }
}
