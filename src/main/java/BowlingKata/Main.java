package BowlingKata;

public class Main {

    public static void main(String[] args) {
        var game = new Game();
        game.addRoll(1);
        game.addRoll(4);
        game.addRoll(4);
        game.addRoll(5);
        System.out.println(game.toString());
    }
}