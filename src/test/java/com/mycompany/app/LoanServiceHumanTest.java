package com.mycompany.app;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LoanServiceHumanTest {

    @Test
    void happyPath_borrow_shouldReturnDueDate() {
        Book book = new Book("ISBN-10", "Refactoring", "Fowler",
                LocalDate.now(), 1);
        LoanService service = new LoanService(7);

        LocalDate due = service.borrow(book, "user1");

        assertNotNull(due);
        assertEquals(0, book.getAvailableCopies());
    }

    @Test
    void borrow_withBlankUser_shouldThrow() {
        Book book = new Book("ISBN-11", "Patterns", "GoF",
                LocalDate.now(), 1);
        LoanService service = new LoanService(7);

        assertThrows(IllegalArgumentException.class,
                () -> service.borrow(book, " "));
    }

    @Test
    void isOverdue_whenAfterDue_shouldReturnTrue() {
        Book book = new Book("ISBN-12", "Java", "Bloch",
                LocalDate.now(), 1);
        LoanService service = new LoanService(1);

        LocalDate due = service.borrow(book, "user2");
        assertTrue(service.isOverdue(book, "user2", due.plusDays(1)));
    }
}
