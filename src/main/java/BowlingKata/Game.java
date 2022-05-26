package BowlingKata;

import java.util.Arrays;

public class Game implements GameInterface{

    private Frame[] frames;
    private int currentThrowCounter;
    private double currentFrameCounter;
    private int totalScore;
    private boolean strikeToResolve;

    public Game() {
        this.frames = new Frame[1];
        this.currentThrowCounter = 0;
        this.currentFrameCounter = 0.0;
        this.totalScore = 0;
        this.strikeToResolve = false;
    }

    @Override
    public void addRoll(int pins) {
        currentThrowCounter += 1;
        createFrame();
        if(strikeToResolve  && pins == 10){
            calculateStrike(pins);
        }
        if(pins == 10 && currentThrowCounter % 2 != 0){
            strikeToResolve = true;
            frames[(int) currentFrameCounter].setPinsRolled(pins, currentThrowCounter);
            currentThrowCounter += 1;
            currentFrameCounter += 1.0;
            return;
        } else {
            frames[(int) currentFrameCounter].setPinsRolled(pins, currentThrowCounter);
        }
        if(strikeToResolve){
            calculateStrike(pins);
        }
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

    private void createFrame() {
        if(currentFrameCounter == 0.0) {
            frames[0] = new Frame();
        }
        if(currentFrameCounter % 1 == 0 && currentFrameCounter != 0.0) {
            frames = Arrays.copyOf(frames, (int) currentFrameCounter + 1);
            frames[(int) currentFrameCounter] = new Frame();
        }
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

    private void calculateStrike(int pins){
        var frameToCheck = frames[(int) currentFrameCounter];
        if(frameToCheck.getPinsRolled().length == 1 && pins == 10){
            frames[(int) currentFrameCounter - 1].setScore(10);
            strikeToResolve = false;
        }
        if(frameToCheck.getPinsRolled().length == 2){
            frames[(int) currentFrameCounter - 1].setScore(frameToCheck.getScore());
            strikeToResolve = false;
        }
    }
}
