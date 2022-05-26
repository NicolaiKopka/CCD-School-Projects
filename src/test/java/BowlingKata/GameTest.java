package BowlingKata;

import org.junit.jupiter.api.Test;

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

}