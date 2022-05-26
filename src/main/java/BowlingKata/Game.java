package BowlingKata;

import java.util.Arrays;

public class Game implements GameInterface{

    private Frame[] frames;
    private int currentThrowCounter;
    private double currentFrameCounter;
    private int totalScore;

    public Game() {
        this.frames = new Frame[1];
        this.currentThrowCounter = 0;
        this.currentFrameCounter = 0.0;
        this.totalScore = 0;
    }

    @Override
    public void addRoll(int pins) {
        currentThrowCounter += 1;
        if(currentFrameCounter == 0.0) {
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
        return frames;
    }

    @Override
    public int totalScore() {
        for(Frame frame : frames){
            totalScore += frame.getScore();
        }
        return totalScore;
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
