package com.mycompany.app;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class LoanService {

    private final Map<String, LocalDate> loanDueDates = new HashMap<>();
    private final int defaultLoanDays;

    public LoanService(int defaultLoanDays) {
        if (defaultLoanDays <= 0) {
            throw new IllegalArgumentException("defaultLoanDays must be > 0");
        }
        this.defaultLoanDays = defaultLoanDays;
    }

    public LocalDate borrow(Book book, String userId) {
        //if (book == null || userId == null || userId.isBlank()) { //JDK 11 dùng dòng nay
        if (book == null || userId == null || userId.isEmpty()) { //JDK 8 dùng dòng nay
            throw new IllegalArgumentException("book and userId are required");
        }
        if (!book.canBorrow()) {
            throw new IllegalStateException("Book not available");
        }
        book.borrow();
        LocalDate due = LocalDate.now().plusDays(defaultLoanDays);
        loanDueDates.put(userId + ":" + book.getIsbn(), due);
        return due;
    }

    public boolean isOverdue(Book book, String userId, LocalDate today) {
        LocalDate due = loanDueDates.get(userId + ":" + book.getIsbn());
        if (due == null) {
            return false;
        }
        return today.isAfter(due);
    }
}