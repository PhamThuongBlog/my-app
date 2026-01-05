package com.mycompany.app;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookHumanTest {

    @Test
    void happyPath_canBorrowAndBorrow() {
        Book book = new Book("ISBN-1", "Clean Code", "Bob",
                LocalDate.now(), 2);

        assertTrue(book.canBorrow());
        book.borrow();
        assertEquals(1, book.getAvailableCopies());
    }

    @Test
    void borrow_whenNoCopies_shouldThrow() {
        Book book = new Book("ISBN-2", "DDD", "Evans",
                LocalDate.now(), 0);

        assertFalse(book.canBorrow());
        assertThrows(IllegalStateException.class, book::borrow);
    }

    @Test
    void constructor_negativeCopies_shouldThrow() {
        assertThrows(IllegalArgumentException.class, () ->
                new Book("ISBN-3", "Test", "Author",
                        LocalDate.now(), -1));
    }
}
