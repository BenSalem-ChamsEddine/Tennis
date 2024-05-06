import java.util.ArrayList;
import java.util.List;

class Match {
    private Player player1;
    private Player player2;
    private List<Game> games;

    public Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.games = new ArrayList<>();
        this.games.add(new Game(player1, player2)); // Ajouter le premier jeu
    }

    public void playerScores(Player player) {
        getCurrentGame().playerScores(player); // Marquer un point dans le jeu en cours
        if (isGameWon()) {
            games.add(new Game(player1, player2)); // Ajouter un nouveau jeu si le jeu en cours est terminé
        }
    }

    public String getScore() {
        StringBuilder scoreBuilder = new StringBuilder();
        for (Game game : games) {
            scoreBuilder.append("(")
                    .append(game.getCurrentGameStatus())
                    .append(") ");
        }
        return scoreBuilder.toString();
    }

    public String getMatchStatus() {
        if (isMatchOver()) {
            int setsPlayer1 = 0;
            int setsPlayer2 = 0;
            for (Game game : games) {
                if (isGameWon()) {
                    if (game.getCurrentGameStatus().startsWith("40")) {
                        setsPlayer1++;
                    } else {
                        setsPlayer2++;
                    }
                }
            }
            return setsPlayer1 > setsPlayer2 ? "Player 1 wins" : "Player 2 wins";
        } else {
            return "In progress";
        }
    }

    private Game getCurrentGame() {
        return games.get(games.size() - 1); // Retourne le dernier jeu de la liste
    }

    private boolean isGameWon() {
        Game currentGame = getCurrentGame();
        return currentGame.getCurrentGameStatus().startsWith("40") &&
                (currentGame.getScorePlayer1() >= currentGame.getScorePlayer2() + 2 || currentGame.getScorePlayer2() >= currentGame.getScorePlayer1() + 2);
    }

    private boolean isMatchOver() {
        int setsPlayer1 = 0;
        int setsPlayer2 = 0;
        for (Game game : games) {
            if (isGameWon()) {
                if (game.getCurrentGameStatus().startsWith("40")) {
                    setsPlayer1++;
                } else {
                    setsPlayer2++;
                }
            }
        }
        return setsPlayer1 >= 3 || setsPlayer2 >= 3;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public List<Game> getGames() {
        return games;
    }
}