package BowlingKata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrameTest {

    @Test
    void shouldReturnCorrectFrameStringAfter1Throw() {
        Frame frame = new Frame();
        frame.setPinsRolled(1, 1);
        String expected = "([1],1)";
        String actual = frame.toString();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectFrameStringAfter2Throws() {
        Frame frame = new Frame();
        frame.setPinsRolled(1, 1);
        frame.setPinsRolled(4, 2);
        String expected = "([1,4],5)";
        String actual = frame.toString();
        assertEquals(expected, actual);
    }

}