package com.mycompany.app;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BookLLMTest {

    @Test
    void getIsbn_shouldNeverBeEmpty() {
        Book book = new Book(
                "ISBN-123",
                "Test",
                "Author",
                LocalDate.now(),
                1
        );

        String isbn = book.getIsbn();

        assertNotNull(isbn);
        assertFalse(isbn.isEmpty(), "ISBN must not be empty");
        assertEquals("ISBN-123", isbn);
    }

    @Test
    void returnBook_shouldIncreaseAvailableCopies() {
        Book book = new Book(
                "ISBN-456",
                "Test",
                "Author",
                LocalDate.now(),
                0
        );

        book.returnBook();

        assertEquals(1, book.getAvailableCopies(),
                "returnBook must increment availableCopies");
    }
}
