package com.mycompany.app;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final LocalDate publishedDate;
    private int availableCopies;

    public Book(String isbn, String title, String author,
                LocalDate publishedDate, int availableCopies) {
       // if (isbn == null || isbn.isBlank()) { JDK 11 dùng dòng này
       if (isbn == null || isbn.trim().isEmpty()) { //JDK 8 dùng dòng này
            throw new IllegalArgumentException("ISBN is required");
        }
        if (availableCopies < 0) {
            throw new IllegalArgumentException("Available copies cannot be negative");
        }
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.availableCopies = availableCopies;
    }

    public boolean canBorrow() {
        return availableCopies > 0;
    }

    public void borrow() {
        if (!canBorrow()) {
            throw new IllegalStateException("No copies available");
        }
        availableCopies--;
    }

    public void returnBook() {
        availableCopies++;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public String getIsbn() {
        return isbn;
    }

    // equals/hashCode by isbn
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}