package BowlingKata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrameTest {

    @Test
    void shouldReturnCorrectFrameStringAfter1Throw() {
        var eligibleThird = false;
        Frame frame = new Frame();
        frame.setPinsRolled(1, 1, eligibleThird);
        String expected = "([1],1)";
        String actual = frame.toString();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectFrameStringAfter2Throws() {
        var eligibleThird = false;
        Frame frame = new Frame();
        frame.setPinsRolled(1, 1, eligibleThird);
        frame.setPinsRolled(4, 2, eligibleThird);
        String expected = "([1,4],5)";
        String actual = frame.toString();
        assertEquals(expected, actual);
    }

}