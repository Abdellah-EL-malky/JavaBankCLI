package utilitaire;

public class ValidatorUtils {
    public static boolean validerMontant(double montant) {
        return montant > 0;
    }

    public static boolean validerCodeCompte(String code) {
        boolean bonneLongueur = code.length() == Constants.LONGUEUR_CODE_TOTAL;

        boolean bonDebut = code.startsWith(Constants.PREFIX_COMPTE);

        String fin = code.substring(4) ;
        boolean bonneFin =  fin.matches("\\d{5}");

        return bonneLongueur && bonDebut && bonneFin;
    }
}