package presentation;

import metier.services.GestionnaireComptes;
import exceptions.CodeCompteInvalideException;
import exceptions.SoldeInsuffisantException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MenuPrincipal {
    private static GestionnaireComptes gestionnaire = new GestionnaireComptes();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ConsoleManager.afficherLogo();

        while (true) {
            try {
                afficherMenuPrincipal();
                int choix = lireChoix();

                if (choix == 0) {
                    System.out.println("Merci d'avoir utilisé Java Bank CLI. Au revoir !");
                    break;
                }

                traiterChoix(choix);

            } catch (Exception e) {
                System.out.println("Erreur inattendue: " + e.getMessage());
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void afficherMenuPrincipal() {
        System.out.println("\n" + "==================================================");
        System.out.println("               MENU PRINCIPAL");
        System.out.println("==================================================");
        System.out.println("1. Créer un compte courant");
        System.out.println("2. Créer un compte épargne");
        System.out.println("3. Effectuer un versement");
        System.out.println("4. Effectuer un retrait");
        System.out.println("5. Effectuer un virement");
        System.out.println("6. Consulter le solde");
        System.out.println("7. Afficher les détails du compte");
        System.out.println("0. Quitter");
        System.out.println("==================================================");
        System.out.print("Votre choix: ");
    }

    private static int lireChoix() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }

    private static void traiterChoix(int choix) {
        scanner.nextLine();

        switch (choix) {
            case 1:
                creerCompteCourant();
                break;
            case 2:
                creerCompteEpargne();
                break;
            case 3:
                effectuerVersement();
                break;
            case 4:
                effectuerRetrait();
                break;
            case 5:
                effectuerVirement();
                break;
            case 6:
                consulterSolde();
                break;
            case 7:
                afficherDetailsCompte();
                break;
            default:
                System.out.println("Choix invalide. Veuillez sélectionner une option entre 0 et 7.");
        }

        if (choix >= 1 && choix <= 7) {
            attendreAppuiTouche();
        }
    }

    private static void creerCompteCourant() {
        System.out.println("\n--- CRÉATION COMPTE COURANT ---");

        try {
            System.out.print("Solde initial (€): ");
            double solde = scanner.nextDouble();

            System.out.print("Découvert autorisé (€): ");
            double decouvert = scanner.nextDouble();

            if (solde < 0) {
                System.out.println("Erreur: Le solde initial ne peut pas être négatif.");
                return;
            }

            if (decouvert < 0) {
                System.out.println("Erreur: Le découvert ne peut pas être négatif.");
                return;
            }

            String code = gestionnaire.creerCompteCourant(solde, decouvert);

            System.out.println("\n✅ Compte courant créé avec succès !");
            System.out.println("Code du compte: " + code);
            System.out.println("Solde initial: " + solde + "€");
            System.out.println("Découvert autorisé: " + decouvert + "€");

        } catch (InputMismatchException e) {
            System.out.println("Erreur: Veuillez saisir un nombre valide.");
            scanner.nextLine();
        }
    }

    private static void creerCompteEpargne() {
        System.out.println("\n--- CRÉATION COMPTE ÉPARGNE ---");

        try {
            System.out.print("Solde initial (€): ");
            double solde = scanner.nextDouble();

            System.out.print("Taux d'intérêt annuel (ex: 0.03 pour 3%): ");
            double tauxInteret = scanner.nextDouble();

            if (solde < 0) {
                System.out.println("Erreur: Le solde initial ne peut pas être négatif.");
                return;
            }

            if (tauxInteret < 0 || tauxInteret > 1) {
                System.out.println("Erreur: Le taux d'intérêt doit être entre 0 et 1.");
                return;
            }

            String code = gestionnaire.creerCompteEpargne(solde, tauxInteret);

            System.out.println("\n✅ Compte épargne créé avec succès !");
            System.out.println("Code du compte: " + code);
            System.out.println("Solde initial: " + solde + "€");
            System.out.println("Taux d'intérêt: " + (tauxInteret * 100) + "%");

        } catch (InputMismatchException e) {
            System.out.println("Erreur: Veuillez saisir un nombre valide.");
            scanner.nextLine();
        }
    }

    private static void effectuerVersement() {
        System.out.println("\n--- VERSEMENT ---");

        try {
            System.out.print("Code du compte (ex: CPT-00001): ");
            String code = scanner.nextLine().trim().toUpperCase();

            System.out.print("Montant à verser (€): ");
            double montant = scanner.nextDouble();

            if (montant <= 0) {
                System.out.println("Erreur: Le montant doit être positif.");
                return;
            }

            boolean success = gestionnaire.effectuerVersement(code, montant);

            if (success) {
                System.out.println("\n✅ Versement effectué avec succès !");
                System.out.println("Montant versé: " + montant + "€");
                System.out.println("Sur le compte: " + code);
            }

        } catch (CodeCompteInvalideException e) {
            System.out.println("❌ Erreur: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Erreur: Veuillez saisir un montant valide.");
            scanner.nextLine();
        }
    }

    private static void effectuerRetrait() {
        System.out.println("\n--- RETRAIT ---");

        try {
            System.out.print("Code du compte (ex: CPT-00001): ");
            String code = scanner.nextLine().trim().toUpperCase();

            System.out.print("Montant à retirer (€): ");
            double montant = scanner.nextDouble();

            if (montant <= 0) {
                System.out.println("Erreur: Le montant doit être positif.");
                return;
            }

            boolean success = gestionnaire.effectuerRetrait(code, montant);

            if (success) {
                System.out.println("\n✅ Retrait effectué avec succès !");
                System.out.println("Montant retiré: " + montant + "€");
                System.out.println("Du compte: " + code);
            }

        } catch (CodeCompteInvalideException e) {
            System.out.println("❌ Erreur: " + e.getMessage());
        } catch (SoldeInsuffisantException e) {
            System.out.println("❌ Erreur: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Erreur: Veuillez saisir un montant valide.");
            scanner.nextLine();
        }
    }

    private static void effectuerVirement() {
        System.out.println("\n--- VIREMENT ---");

        try {
            System.out.print("Code du compte débiteur (qui paye): ");
            String compteDebiteur = scanner.nextLine().trim().toUpperCase();

            System.out.print("Code du compte créditeur (qui reçoit): ");
            String compteCrediteur = scanner.nextLine().trim().toUpperCase();

            if (compteDebiteur.equals(compteCrediteur)) {
                System.out.println("Erreur: Impossible de faire un virement sur le même compte.");
                return;
            }

            System.out.print("Montant du virement (€): ");
            double montant = scanner.nextDouble();

            if (montant <= 0) {
                System.out.println("Erreur: Le montant doit être positif.");
                return;
            }

            boolean success = gestionnaire.effectuerVirement(compteDebiteur, compteCrediteur, montant);

            if (success) {
                System.out.println("\n✅ Virement effectué avec succès !");
                System.out.println("Montant: " + montant + "€");
                System.out.println("De: " + compteDebiteur + " vers: " + compteCrediteur);
            }

        } catch (CodeCompteInvalideException e) {
            System.out.println("❌ Erreur: " + e.getMessage());
        } catch (SoldeInsuffisantException e) {
            System.out.println("❌ Erreur: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Erreur: Veuillez saisir un montant valide.");
            scanner.nextLine();
        }
    }

    private static void consulterSolde() {
        System.out.println("\n--- CONSULTATION SOLDE ---");

        try {
            System.out.print("Code du compte (ex: CPT-00001): ");
            String code = scanner.nextLine().trim().toUpperCase();

            gestionnaire.consulterSolde(code);

        } catch (CodeCompteInvalideException e) {
            System.out.println("❌ Erreur: " + e.getMessage());
        }
    }



    private static void attendreAppuiTouche() {
        System.out.println("\nAppuyez sur Entrée pour continuer...");
        scanner.nextLine();
    }
}