package io.github.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    BirdTest.class,   // Include the BirdTest class
    BlockTest.class   // Include the BlockTest class
})
public class AllTest {
    // This class remains empty. It's used only as a holder for the above annotations.
}
