package ohtu;

public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1Score += 1;
        } else if (playerName.equals(player2Name)) {
            player2Score += 1;
        } else {
            throw new IllegalArgumentException("No such player");
        }
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;

        if (player1Score == player2Score) {
            return evenScore();
        } else if (player1Score >= 4 || player2Score >= 4) {
            return highUnevenScore();
        } else {
            return lowUnevenScore();
        }
    }

    private String lowUnevenScore() {
        String score = numericToAlphabetic(player1Score);
        score += "-";
        score += numericToAlphabetic(player2Score);
        return score;
    }

    private String numericToAlphabetic(int playerScore) {
        String score = "";
        switch (playerScore) {
            case 0:
                score = "Love";
                break;
            case 1:
                score = "Fifteen";
                break;
            case 2:
                score = "Thirty";
                break;
            case 3:
                score = "Forty";
                break;
        }
        return score;
    }

    private String evenScore() {
        String score;
        switch (player1Score) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }

    private String highUnevenScore() {
        String score;
        int difference = player1Score - player2Score;
        if (difference == 1) {
            score = "Advantage player1";
        } else if (difference == -1) {
            score = "Advantage player2";
        } else if (difference >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
    }
}
