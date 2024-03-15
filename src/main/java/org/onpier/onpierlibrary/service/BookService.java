package org.onpier.onpierlibrary.service;

import lombok.RequiredArgsConstructor;
import org.onpier.onpierlibrary.loader.model.Book;
import org.onpier.onpierlibrary.persistence.repository.BookRepository;
import org.onpier.onpierlibrary.util.BookConverter;
import org.onpier.onpierlibrary.util.Validator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void saveBook(Book book) {
        if (Validator.isBookNotEmpty(book)) {
            bookRepository.save(BookConverter.toBookEntity(book));
        }
    }

    public org.onpier.onpierlibrary.persistence.model.Book findBookByTitle(String title){
        return bookRepository.findBookByTitle(title);
    }
}
