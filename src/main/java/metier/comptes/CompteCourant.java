package metier.comptes;

import metier.operations.Retrait;
import exceptions.SoldeInsuffisantException;
import utilitaire.Constants;

public class CompteCourant extends Compte{
    protected double decouvert;

    public CompteCourant(double decouvert, String code, double solde){
        super(code, solde);
        this.decouvert = decouvert;
    }

    @Override
    public boolean retirer(double montant) throws SoldeInsuffisantException{

        if((solde - montant) >= -decouvert) {
            this.solde = solde - montant;
            Retrait operation = new Retrait(montant, "Retrait automatique");
            listeOperations.add(operation);
            return true;
        } else {
            throw new SoldeInsuffisantException(Constants.MSG_SOLDE_INSUFFISANT);
        }

    }

    @Override
    public double calculerInteret(){
    return 0;
    }

    @Override
    public void afficherDetails(){
        System.out.println("=== COMPTE COURANT ===");
        System.out.println("Code: " + this.code);
        System.out.println("Solde: " + this.solde + "€");
        System.out.println("Découvert autorisé: " + this.decouvert + "€");
        System.out.println("Nombre d'opérations: " + this.listeOperations.size());
    }
}