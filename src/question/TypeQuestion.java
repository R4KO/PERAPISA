package src.question;

abstract public class TypeQuestion {
    protected String theme;
    protected int niveau;
    protected String proposition = "";

    abstract public void afficher();
    @Override
    public String toString() {
        String output = "";
        output += "Thème: " + theme + "\n"
                + "Niveau = " + niveau + "\n";
        if (!proposition.isEmpty()) {
            output += proposition + "\n";
        }
        return output;
    }
}
