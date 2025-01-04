public class NombreNegatifException extends Exception {
    private final int valeur;

    public NombreNegatifException(int valeur) {
        super("Valeur négative : " + valeur);
        this.valeur = valeur;
    }

    public int getValeur() {
        return valeur;
    }
}
