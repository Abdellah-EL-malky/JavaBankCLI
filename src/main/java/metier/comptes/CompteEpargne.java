package metier.comptes;

import metier.operations.Retrait;
import exceptions.SoldeInsuffisantException;
import utilitaire.Constants;

public class CompteEpargne extends Compte{
    protected double tauxInteret;

    public CompteEpargne(double tauxInteret, String code, double solde){
        super(code ,solde);
        this.tauxInteret = tauxInteret;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    @Override
    public  boolean retirer(double montant) throws SoldeInsuffisantException{
        if(solde >= montant) {
            this.solde = solde - montant;
            Retrait operation = new Retrait(montant, "Retrait automatique");
            listeOperations.add(operation);
            return true;
        } else {
            throw new SoldeInsuffisantException(Constants.MSG_SOLDE_INSUFFISANT);
        }
    }

    @Override
    public  double calculerInteret(){
        return solde * tauxInteret;
    }

    @Override
    public  void afficherDetails(){
        System.out.println("=== COMPTE EPARGNE ===");
        System.out.println("Code: " + this.code);
        System.out.println("Solde: " + this.solde + "€");
        System.out.println("Taux d'intérêt: " + (this.tauxInteret * 100) + "%");
        System.out.println("Intérêts calculés: " + this.calculerInteret() + "€");
        System.out.println("Nombre d'opérations: " + this.listeOperations.size());
    }
}