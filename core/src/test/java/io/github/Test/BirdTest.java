package io.github.Test;

import io.github.some_example_name.Bird_obj;
import org.junit.Test;

import static org.junit.Assert.*;

public class BirdTest {
    @Test
    public void testReduceHealth() {
        Bird_obj bird = new Bird_obj(10); // Bird starts with 10 health

        bird.reduceHealth(3); // Reduce health by 3
        assertEquals("Health should be reduced to 7.", 7, bird.getHealth());

        bird.reduceHealth(10); // Reduce health by more than remaining
        assertEquals("Health should not go below 0.", 0, bird.getHealth());
    }

    @Test
    public void testIsAlive() {
        Bird_obj bird = new Bird_obj(1); // Bird starts with 1 health

        assertTrue("Bird should be alive.", bird.isAlive());

        bird.reduceHealth(1); // Reduce health to 0
        assertFalse("Bird should not be alive after health reaches 0.", bird.isAlive());
    }
}
