package org.onpier.onpierlibrary.service;

import lombok.RequiredArgsConstructor;
import org.onpier.onpierlibrary.loader.model.Borrowing;
import org.onpier.onpierlibrary.persistence.model.Book;
import org.onpier.onpierlibrary.persistence.model.User;
import org.onpier.onpierlibrary.persistence.repository.BorrowingRepository;
import org.onpier.onpierlibrary.util.BorrowingConverter;
import org.onpier.onpierlibrary.util.Validator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BorrowingService {

    private final UserService userService;
    private final BookService bookService;
    private final BorrowingRepository borrowingRepository;

    public void saveBorrowing(Borrowing borrowing) {
        if (Validator.isBorrowingNotEmpty(borrowing)) {
            Book book = bookService.findBookByTitle(borrowing.book());
            User user = userService.findUserByBorrower(borrowing.borrower());
            borrowingRepository.save(BorrowingConverter.toBorrowingEntity(borrowing, user, book));
        }
    }
}
