package metier.comptes;

import java.util.ArrayList;
import java.util.List;

import exceptions.SoldeInsuffisantException;
import metier.operations.Operation;
import metier.operations.Versement;

public abstract class Compte {
    protected String code;
    protected double solde;
    protected List<Operation> listeOperations;

    public Compte(String code, double solde) {
        this.code = code;
        this.solde = solde;
        this.listeOperations = new ArrayList<>();
    }

    public double getSolde() {
        return solde;
    }

    public String getCode() {
        return code;
    }

    public abstract boolean retirer(double montant) throws SoldeInsuffisantException;

    public abstract double calculerInteret();

    public abstract void afficherDetails();

    public void verser(double montant) {
        this.solde = solde + montant;
        Versement operation = new Versement(montant, "Dépôt espèces");
        listeOperations.add(operation);
    }
}

