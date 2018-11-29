package ohtu;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello tennis world!");

        TennisGame game = new TennisGame("player1", "player2");

        System.out.println(game.getScore());

        game.wonPoint("player1");
        System.out.println(game.getScore());

        game.wonPoint("player2");
        System.out.println(game.getScore());

        game.wonPoint("player1");
        System.out.println(game.getScore());

        game.wonPoint("player2");
        System.out.println(game.getScore());

        game.wonPoint("player1");
        System.out.println(game.getScore());
        
        game.wonPoint("player2");
        System.out.println(game.getScore());
        
        game.wonPoint("player2");
        System.out.println(game.getScore());
        
        game.wonPoint("player2");
        System.out.println(game.getScore());
        
        game.wonPoint("player1");
        System.out.println(game.getScore());
    }

}
