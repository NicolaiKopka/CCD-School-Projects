package BowlingKata;

public interface GameInterface {

    void addRoll(int pins);
    Frame[] frames();
    int totalScore();
    boolean over();
}
