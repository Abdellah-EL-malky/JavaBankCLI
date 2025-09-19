src/
└── main/
    ├── presentation/                    # Couche de présentation (UI/Menu)
    │   ├── MenuPrincipal.java
    │   ├── InterfaceUtilisateur.java
    │   └── ConsoleManager.java
    │
    ├── metier/                         # Couche métier (logique métier)
    │   ├── comptes/                    # Gestion des comptes
    │   │   ├── Compte.java             # Classe abstraite
    │   │   ├── CompteCourant.java
    │   │   └── CompteEpargne.java
    │   │
    │   ├── operations/                 # Gestion des opérations
    │   │   ├── Operation.java          # Classe abstraite
    │   │   ├── Versement.java
    │   │   └── Retrait.java
    │   │
    │   └── services/                   # Services métier
    │       ├── GestionnaireComptes.java
    │       └── ValidationService.java
    │
    ├── utilitaire/                     # Couche utilitaire
    │   ├── DateUtils.java
    │   ├── FormatUtils.java
    │   ├── ValidatorUtils.java
    │   └── Constants.java
    │
    ├── persistance/                    # Couche de persistance (optionnelle)
    │   ├── CompteDAO.java
    │   └── FileManager.java
    │
    └── exceptions/                     # Couche des exceptions métier
        ├── CompteException.java
        ├── SoldeInsuffisantException.java
        └── CodeCompteInvalideException.java
