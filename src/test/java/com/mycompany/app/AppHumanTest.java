package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    
    @Test
    public void testAddPositive() {
        App app = new App();
        assertEquals(5, app.add(2, 3));
    }

    @Test
    public void testAddNegative() {
        App app = new App();
        assertEquals(3, app.add(-1, 3));
    }
}

