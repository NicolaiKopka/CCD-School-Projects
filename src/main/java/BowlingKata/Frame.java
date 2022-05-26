package BowlingKata;

import java.util.Arrays;

public class Frame {

    private int[] pinsRolled;
    private int score; // score only this frame

    public Frame() {
        this.pinsRolled = new int[1];
    }

    void setPinsRolled(int pins, int currentThrowNumber, boolean eligibleThird) {
        if (eligibleThird) {
            pinsRolled = Arrays.copyOf(pinsRolled, 3);
            pinsRolled[2] = pins;
            calculateScore();
            return;
        }
        if(currentThrowNumber % 2 == 0){
            pinsRolled = Arrays.copyOf(pinsRolled, 2);
            pinsRolled[1] = pins;
        } else {
            pinsRolled[0] = pins;
        }
        calculateScore();
    }

    private void calculateScore() {
        score = 0;
        for (int pins : pinsRolled) {
            score += pins;
        }
    }

    @Override
    public String toString() {
        var stringBuilder = new StringBuilder();
        stringBuilder.append("([");
        for (int i = 0; i < pinsRolled.length; i++) {
            if(i == 0) {
                stringBuilder.append(pinsRolled[i]);
            } else {
                stringBuilder.append(",").append(pinsRolled[i]);
            }
        }
        stringBuilder.append("],").append(score).append(")");
        return stringBuilder.toString();
    }

    public int getScore() {
        return score;
    }

    public int[] getPinsRolled() {
        return pinsRolled;
    }

    public void setScore(int score) {
        this.score += score;
    }
}
