class CompteCourant extends CompteBancaire {
    private double decouvertAutorise;

    public CompteCourant(String numero, String titulaire, double soldeInitial, double decouvertAutorise) {
        super(numero, titulaire, soldeInitial);
        this.decouvertAutorise = decouvertAutorise;
    }

    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }

    public void setDecouvertAutorise(double decouvertAutorise) {
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public void retrait(double montant) throws FondsInsuffisantsException {
        if (montant > (getSolde() + decouvertAutorise)) {
            throw new FondsInsuffisantsException("Fonds insuffisants même avec découvert autorisé.");
        }
        setSolde(getSolde() - montant);
    }
}