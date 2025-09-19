package presentation;

public class ConsoleManager {
    public static void afficherLogo() {
        String cyan = "\u001B[36m";
        String reset = "\u001B[0m";

        System.out.println(cyan + "===     ░█████    ░███    ░██    ░██    ░███    ░████████     ░███       ░███    ░██ ░██     ░██      ░██████  ░██         ░██████\n" +
                "      ░██    ░██░██   ░██    ░██   ░██░██   ░██    ░██    ░██░██   ░████   ░██ ░██    ░██      ░██   ░██ ░██           ░██  \n" +
                "      ░██   ░██  ░██  ░██    ░██  ░██  ░██  ░██    ░██   ░██  ░██  ░██░██  ░██ ░██   ░██      ░██        ░██           ░██  \n" +
                "      ░██  ░█████████ ░██    ░██ ░█████████ ░████████   ░█████████ ░██ ░██ ░██ ░███████       ░██        ░██           ░██  \n" +
                "░██   ░██  ░██    ░██  ░██  ░██  ░██    ░██ ░██     ░██ ░██    ░██ ░██  ░██░██ ░██   ░██      ░██        ░██           ░██  \n" +
                "░██   ░██  ░██    ░██   ░██░██   ░██    ░██ ░██     ░██ ░██    ░██ ░██   ░████ ░██    ░██      ░██   ░██ ░██           ░██  \n" +
                " ░██████   ░██    ░██    ░███    ░██    ░██ ░█████████  ░██    ░██ ░██    ░███ ░██     ░██      ░██████  ░██████████ ░██████\n" +
                "                                                                                                                            \n" +
                "                                                                                                                            \n" +
                "                                                                                                                             ===" + reset);
        System.out.println();
        System.out.println("Bienvenue dans votre système de gestion bancaire !");
        System.out.println("Toutes les opérations sont sécurisées et tracées.");
        System.out.println();
    }

    public static void afficherMessageSucces(String message) {
        System.out.println("✅ " + message);
    }

    public static void afficherMessageErreur(String message) {
        System.out.println("❌ " + message);
    }

    public static void afficherSeparateur() {
        System.out.println("--------------------------------------------------");
    }

    public static void nettoierConsole() {
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
            Process startProcess = pb.inheritIO().start();
            startProcess.waitFor();
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
}