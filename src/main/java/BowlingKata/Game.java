package BowlingKata;

import java.util.Arrays;

public class Game implements GameInterface{

    private Frame[] frames;
    private int currentThrowCounter = 0;
    private double currentFrameCounter = 0.0;
    @Override
    public void addRoll(int pins) {
        currentThrowCounter += 1;
        if(currentFrameCounter == 0.0) {
            frames = new Frame[1];
            frames[0] = createFrame();
        }
        if(currentFrameCounter % 1 == 0 && currentFrameCounter != 0.0) {
            frames = Arrays.copyOf(frames, (int) currentFrameCounter + 1);
            frames[(int) currentFrameCounter] = createFrame();
        }
        frames[(int) currentFrameCounter].setPinsRolled(pins, currentThrowCounter);
        currentFrameCounter += 0.5;
    }

    @Override
    public Frame[] frames() {
        return new Frame[0];
    }

    @Override
    public int totalScore() {
        return 0;
    }

    @Override
    public boolean over() {
        return false;
    }

    private Frame createFrame() {
        return new Frame();
    }

    @Override
    public String toString() {
        var stringBuilder = new StringBuilder();
        for (int i = 0; i < frames.length; i++) {
            stringBuilder.append(frames[i].toString());
            if(i != (frames.length - 1)){
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }
}
