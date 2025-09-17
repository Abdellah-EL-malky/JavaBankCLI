package metier.comptes;

import java.util.List;
import metier.operations.Operation;

public abstract class Compte {
    protected String code;
    protected double solde;
    protected List<Operation> listeOperations;

    public abstract boolean retirer(double montant);

    public abstract double calculerInteret();

    public abstract void afficherDetails();
}

