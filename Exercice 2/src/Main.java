import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        ArrayList<CompteBancaire> comptes = new ArrayList<>();

        // Ajouter des comptes
        comptes.add(new CompteCourant("1", "Saad", 1000, 500));
        comptes.add(new CompteEpargne("2", "Rhita", 2000, 0.03));

        try {
            // Retirer de l'argent avec découvert autorisé
            comptes.get(0).retrait(1200);
            comptes.get(0).afficherSolde();

            // Transférer de l'argent vers un compte valide
            comptes.get(0).transfertVers(comptes.get(1), 300);
            comptes.get(0).afficherSolde();
            comptes.get(1).afficherSolde();

            // Transférer de l'argent vers un compte inexistant
            comptes.get(0).transfertVers(null, 100);
        } catch (FondsInsuffisantsException | CompteInexistantException e) {
            System.err.println("Erreur: " + e.getMessage());
        }

        try {
            // Retirer plus que le solde sans découvert
            comptes.get(1).retrait(5000);
        } catch (FondsInsuffisantsException e) {
            System.err.println("Erreur lors du retrait: " + e.getMessage());
        }

        comptes.remove(0);
        System.out.println("Compte 1 supprimé.");
    }
}