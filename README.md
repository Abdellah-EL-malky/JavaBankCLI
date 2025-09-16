Structure du projet:

src/
├── presentation/           # Couche de présentation (UI/Menu)
│   ├── MenuPrincipal.java
│   ├── InterfaceUtilisateur.java
│   └── ConsoleManager.java
│
├── metier/                # Couche métier (logique métier)
│   ├── comptes/
│   │   ├── Compte.java           # Classe abstraite
│   │   ├── CompteCourant.java
│   │   └── CompteEpargne.java
│   │
│   ├── operations/
│   │   ├── Operation.java        # Classe abstraite
│   │   ├── Versement.java
│   │   └── Retrait.java
│   │
│   └── services/
│       ├── GestionnaireComptes.java
│       └── ValidationService.java
│
├── utilitaire/            # Couche utilitaire
│   ├── DateUtils.java
│   ├── FormatUtils.java
│   ├── ValidatorUtils.java
│   └── Constants.java
│
├── persistance/           # Couche de persistance (optionnelle)
│   ├── CompteDAO.java
│   └── FileManager.java
│
└── exceptions/            # Couche des exceptions métier
├── CompteException.java
├── SoldeInsuffisantException.java
└── CodeCompteInvalideException.java

───────────────────────────────────────────────────────────────────────────────────────────────────────────────

