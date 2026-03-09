package project20280.stacksqueues;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExercisesTest {

    @Test
    void testConvertToBinary() {
        assertEquals("10111", Exercises.convertToBinary(23));
        assertEquals("111001000000101011000010011101010110110001100010000000000000",
                Exercises.convertToBinary(1027010000000000000L));
        }

}