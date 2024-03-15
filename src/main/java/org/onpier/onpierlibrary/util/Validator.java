package org.onpier.onpierlibrary.util;

import lombok.experimental.UtilityClass;
import org.onpier.onpierlibrary.loader.model.Book;
import org.onpier.onpierlibrary.loader.model.Borrowing;
import org.onpier.onpierlibrary.loader.model.User;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@UtilityClass
public class Validator {

    public boolean isBookNotEmpty(Book book) {
        return StringUtils.hasText(book.title()) &&
                StringUtils.hasText(book.author()) &&
                StringUtils.hasText(book.genre()) &&
                StringUtils.hasText(book.publisher());
    }

    public boolean isUserNotEmpty(User user) {
        return StringUtils.hasText(user.lastName()) &&
                StringUtils.hasText(user.firstName()) &&
                !ObjectUtils.isEmpty(user.memberSince()) &&
                StringUtils.hasText(user.gender());
    }

    public boolean isBorrowingNotEmpty(Borrowing borrowing) {
        return StringUtils.hasText(borrowing.borrower()) &&
                StringUtils.hasText(borrowing.book()) &&
                !ObjectUtils.isEmpty(borrowing.borrowedFrom()) &&
                !ObjectUtils.isEmpty(borrowing.borrowedTo());
    }
}
