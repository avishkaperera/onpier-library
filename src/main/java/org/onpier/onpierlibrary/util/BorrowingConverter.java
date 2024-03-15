package org.onpier.onpierlibrary.util;

import lombok.experimental.UtilityClass;
import org.onpier.onpierlibrary.persistence.model.Book;
import org.onpier.onpierlibrary.persistence.model.Borrowing;
import org.onpier.onpierlibrary.persistence.model.User;

@UtilityClass
public class BorrowingConverter {

    public Borrowing toBorrowingEntity(org.onpier.onpierlibrary.loader.model.Borrowing borrowing,
                                       User user,
                                       Book book) {
        return Borrowing.builder()
                .borrower(user)
                .book(book)
                .borrowedFrom(borrowing.borrowedFrom())
                .borrowedTo(borrowing.borrowedTo())
                .build();
    }
}
