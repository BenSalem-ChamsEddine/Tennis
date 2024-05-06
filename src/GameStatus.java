public class GameStatus {
    private GameScore scorePlayer1;
    private GameScore scorePlayer2;

    public GameStatus(GameScore scorePlayer1, GameScore scorePlayer2) {
        this.scorePlayer1 = scorePlayer1;
        this.scorePlayer2 = scorePlayer2;
    }

    public GameScore getScorePlayer1() {
        return scorePlayer1;
    }

    public GameScore getScorePlayer2() {
        return scorePlayer2;
    }
}