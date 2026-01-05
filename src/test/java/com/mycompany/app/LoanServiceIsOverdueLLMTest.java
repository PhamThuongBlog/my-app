package com.mycompany.app;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LoanServiceIsOverdueLLMTest {

    @Test
    void isOverdue_whenBeforeDueDate_shouldReturnFalse() {
        LoanService service = new LoanService(7);

        Book book = new Book(
                "ISBN-789",
                "Test",
                "Author",
                LocalDate.now(),
                1
        );

        service.borrow(book, "user1");

        LocalDate today = LocalDate.now().plusDays(3);

        assertFalse(service.isOverdue(book, "user1", today),
                "Book should not be overdue before due date");
    }
}
