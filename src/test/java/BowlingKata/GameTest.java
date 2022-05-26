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

}