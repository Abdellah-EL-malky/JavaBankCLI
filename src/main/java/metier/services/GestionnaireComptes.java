package metier.services;

import java.util.HashMap;
import metier.comptes.Compte;
import metier.comptes.CompteCourant;
import metier.comptes.CompteEpargne;

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

    public boolean effectuerVersement(String codeCompte, double montant){

    }

    public boolean effectuerRetrait(String codeCompte, double montant){

    }

    public void consulterSolde(String codeCompte){

    }
}