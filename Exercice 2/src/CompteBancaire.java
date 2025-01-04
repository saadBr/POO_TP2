class CompteBancaire {
    private String numero;
    private double solde;
    private String titulaire;

    public CompteBancaire(String numero, String titulaire, double soldeInitial) {
        this.numero = numero;
        this.titulaire = titulaire;
        this.solde = soldeInitial;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(String titulaire) {
        this.titulaire = titulaire;
    }

    public void depot(double montant) {
        solde += montant;
    }

    public void retrait(double montant) throws FondsInsuffisantsException {
        if (montant > solde) {
            throw new FondsInsuffisantsException("Fonds insuffisants pour retirer " + montant);
        }
        solde -= montant;
    }

    public void afficherSolde() {
        System.out.println("Compte " + numero + ": Solde = " + solde);
    }

    public void transfertVers(CompteBancaire autreCompte, double montant) throws FondsInsuffisantsException, CompteInexistantException {
        if (autreCompte == null) {
            throw new CompteInexistantException("Compte de destination inexistant.");
        }
        this.retrait(montant);
        autreCompte.depot(montant);
    }
}