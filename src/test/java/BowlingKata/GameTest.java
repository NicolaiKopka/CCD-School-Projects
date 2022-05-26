package BowlingKata;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void shouldReturnCorrectFrameAfterFirstTwoThrows() {
        var game = new Game();
        game.addRoll(1);
        game.addRoll(4);
        String expected = "([1,4],5)";
        String actual = game.toString();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectFrameAfterFirstTwoThrowsFromFrames() {
        var game = new Game();
        game.addRoll(1);
        game.addRoll(4);
        String expected = "[([1,4],5)]";
        String actual = Arrays.toString(game.frames());
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectFramesAfterFirstFourThrows() {
        var game = new Game();
        game.addRoll(1);
        game.addRoll(4);
        game.addRoll(4);
        game.addRoll(5);
        String expected = "([1,4],5), ([4,5],9)";
        String actual = game.toString();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectFramesAfterFirstSixThrows() {
        var game = new Game();
        game.addRoll(1);
        game.addRoll(4);
        game.addRoll(4);
        game.addRoll(5);
        game.addRoll(6);
        game.addRoll(4);
        String expected = "([1,4],5), ([4,5],9), ([6,4],10)";
        String actual = game.toString();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectScoreAfterFirstSixThrows() {
        var game = new Game();
        game.addRoll(1);
        game.addRoll(4);
        game.addRoll(4);
        game.addRoll(5);
        game.addRoll(6);
        game.addRoll(4);
        int expected = 24;
        int actual = game.totalScore();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectScoreAfterResolvingStrike() {
        var game = new Game();
        game.addRoll(10);
        game.addRoll(4);
        game.addRoll(5);
        String expected = "([10],19), ([4,5],9)";
        String actual = game.toString();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectScoreAfterResolvingMultipleStrikes() {
        var game = new Game();
        game.addRoll(2);
        game.addRoll(7);
        game.addRoll(10);
        game.addRoll(10);
        game.addRoll(10);
        game.addRoll(4);
        game.addRoll(5);
        String expected = "([2,7],9), ([10],20), ([10],20), ([10],19), ([4,5],9)";
        String actual = game.toString();
        assertEquals(expected, actual);
        int expectedScore = 77;
        int actualScore = game.totalScore();
        assertEquals(expectedScore, actualScore);
    }

}