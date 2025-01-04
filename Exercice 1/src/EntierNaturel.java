import java.util.Scanner;

public class EntierNaturel {
    private int val;

    public EntierNaturel(int val) throws NombreNegatifException {
        if (val < 0) {
            throw new NombreNegatifException(val);
        }
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) throws NombreNegatifException {
        if (val < 0) {
            throw new NombreNegatifException(val);
        }
        this.val = val;
    }

    public void decrementer() throws NombreNegatifException {
        if (val - 1 < 0) {
            throw new NombreNegatifException(val - 1);
        }
        val--;
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Entrez une valeur: ");
            int val = sc.nextInt();
            EntierNaturel entier = new EntierNaturel(val);
            System.out.println("Valeur initiale: " + entier.getVal());
            entier.decrementer();
            System.out.println("Après décrémentation: " + entier.getVal());

        } catch (NombreNegatifException e) {
            System.err.println("Exception attrapée: " + e.getMessage());
            System.err.println("Valeur erronée: " + e.getValeur());
        }
    }
}
