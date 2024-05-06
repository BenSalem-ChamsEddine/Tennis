import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // Création des joueurs
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // Création du match
        Match match = new Match(player1, player2);

        // Simulation du match
        simulateMatch(match);

        // Affichage du statut du match
        System.out.println("Player 1: " + player1.getName());
        System.out.println("Player 2: " + player2.getName());
        System.out.println("Score: " + match.getScore());
        System.out.println("Match Status: " + match.getMatchStatus());
    }

    public static void simulateMatch(Match match) {
        Player player1 = match.getPlayer1();
        Player player2 = match.getPlayer2();
        for (int i = 0; i < 10; i++) { // Simulation de 10 points pour le match
            if (Math.random() < 0.5) {
                match.playerScores(player1);
            } else {
                match.playerScores(player2);
            }
        }
    }
}
