package com.mycompany.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoanServiceLLMTest {

    @Test
    void constructor_withZeroLoanDays_shouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LoanService(0);
        });
    }

    @Test
    void constructor_withNegativeLoanDays_shouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LoanService(-5);
        });
    }
}
