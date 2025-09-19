package metier.services;

import java.util.HashMap;

import exceptions.CodeCompteInvalideException;
import exceptions.SoldeInsuffisantException;
import metier.comptes.Compte;
import metier.comptes.CompteCourant;
import metier.comptes.CompteEpargne;
import utilitaire.Constants;

public class GestionnaireComptes {
    private int compteurCode = 1;
    private HashMap<String, Compte> comptes = new HashMap<>();

    private String genererProchainCode() {
        String code = String.format("CPT-%05d", compteurCode++);
        return code;
    }

    public String creerCompteCourant(double solde, double decouvert) {
        String code = genererProchainCode();
        System.out.println("Votre code: " + code);
        CompteCourant monCompteCourant = new CompteCourant(decouvert, code, solde);
        comptes.put(code, monCompteCourant);
        return code;
    }

    public String creerCompteEpargne(double solde, double tauxInteret) {
        String code = genererProchainCode();
        System.out.println("Votre code: " + code);
        CompteEpargne monCompteEpargne = new CompteEpargne(tauxInteret, code, solde);
        comptes.put(code, monCompteEpargne);
        return code;
    }

    public boolean effectuerVersement(String codeCompte, double montant) throws CodeCompteInvalideException{
        Compte compte = comptes.get(codeCompte);
        if (compte == null){
        throw new CodeCompteInvalideException(Constants.MSG_COMPTE_INEXISTANT);
        } else {
            compte.verser(montant);
            return true;
        }
    }

    public boolean effectuerRetrait(String codeCompte, double montant) throws CodeCompteInvalideException, SoldeInsuffisantException {
        Compte compte = comptes.get(codeCompte);
        if (compte == null){
            throw new CodeCompteInvalideException(Constants.MSG_COMPTE_INEXISTANT);
        } else {
            compte.retirer(montant);
            return true;
        }

    }

    public void consulterSolde(String codeCompte) throws CodeCompteInvalideException{
        Compte compte = comptes.get(codeCompte);
        if (compte == null){
            throw new CodeCompteInvalideException(Constants.MSG_COMPTE_INEXISTANT);
        } else {
            double solde = compte.getSolde();
            System.out.println("Solde: " + solde + "€");
        }
    }

    public boolean effectuerVirement(String compteDebiteur, String compteCrediteur, double montant) throws CodeCompteInvalideException, SoldeInsuffisantException {
        Compte compteSource = comptes.get(compteDebiteur);
        Compte compteDestination = comptes.get(compteCrediteur);

        if (compteSource == null || compteDestination == null) {
            throw new CodeCompteInvalideException(Constants.MSG_COMPTE_INEXISTANT);
        }

        compteSource.retirer(montant);
        compteDestination.verser(montant);

        System.out.println("Virement de " + montant + "€ effectué de " + compteDebiteur + " vers " + compteCrediteur);
        return true;
    }
}