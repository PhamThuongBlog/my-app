package com.mycompany.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppLLMTest {

    @Test
    void add_zeroAndPositive_shouldWork() {
        App app = new App();
        assertEquals(5, app.add(0, 5));
    }

    @Test
    void add_zeroAndZero_shouldReturnZero() {
        App app = new App();
        assertEquals(0, app.add(0, 0));
    }
}
