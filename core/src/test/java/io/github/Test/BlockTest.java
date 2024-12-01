package io.github.Test;

import org.junit.Test;

import static org.junit.Assert.*;
import io.github.some_example_name.Block_obj;

public class BlockTest {
    @Test
    public void testReduceHealth() {
        Block_obj block = new Block_obj(5); // Block starts with 5 health

        block.reduceHealth(2); // Reduce health by 2
        assertEquals("Health should be reduced to 3.", 3, block.getHealth());

        block.reduceHealth(10); // Reduce health by more than remaining
        assertEquals("Health should not go below 0.", 0, block.getHealth());
    }

    @Test
    public void testIsDestroyed() {
        Block_obj block = new Block_obj(1); // Block starts with 1 health

        assertFalse("Block should not be destroyed initially.", block.isDestroyed());

        block.reduceHealth(1); // Reduce health to 0
        assertTrue("Block should be destroyed after health reaches 0.", block.isDestroyed());
    }
}
