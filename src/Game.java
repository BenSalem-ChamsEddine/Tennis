class Game {
    private Player player1;
    private Player player2;
    private int scorePlayer1;
    private int scorePlayer2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.scorePlayer1 = 0;
        this.scorePlayer2 = 0;
    }

    public void playerScores(Player player) {
        if (player.equals(player1)) {
            scorePlayer1++;
        } else if (player.equals(player2)) {
            scorePlayer2++;
        }
    }

    public String getCurrentGameStatus() {
        if (scorePlayer1 >= 3 && scorePlayer2 >= 3) {
            if (scorePlayer1 == scorePlayer2) {
                return "Deuce";
            } else if (scorePlayer1 == scorePlayer2 + 1 || scorePlayer2 == scorePlayer1 + 1) {
                return "Advantage";
            }
        }
        return convertScore(scorePlayer1) + "-" + convertScore(scorePlayer2);
    }

    private String convertScore(int score) {
        switch (score) {
            case 0:
                return "0";
            case 1:
                return "15";
            case 2:
                return "30";
            case 3:
                return "40";
            default:
                return "";
        }
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public int getScorePlayer1() {
        return scorePlayer1;
    }

    public int getScorePlayer2() {
        return scorePlayer2;
    }
}