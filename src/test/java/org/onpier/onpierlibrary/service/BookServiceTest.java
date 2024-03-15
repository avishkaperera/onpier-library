package org.onpier.onpierlibrary.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.onpier.onpierlibrary.loader.model.Book;
import org.onpier.onpierlibrary.persistence.repository.BookRepository;
import org.onpier.onpierlibrary.util.BookConverter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    void saveBook() {
        Book book = new Book(
                "Wealth of Nations, The",
                "Smith, Adam",
                "economics",
                "Random House");
        bookService.saveBook(book);
        verify(bookRepository, times(1)).save(BookConverter.toBookEntity(book));
    }

    @Test
    void findBookByTitle() {
        org.onpier.onpierlibrary.persistence.model.Book book = org.onpier.onpierlibrary.persistence.model.Book.builder()
                .publisher("Random House")
                .title("Wealth of Nations, The")
                .genre("economics")
                .author("Smith, Adam")
                .build();
        doReturn(book).when(bookRepository).findBookByTitle(anyString());
        org.onpier.onpierlibrary.persistence.model.Book result = bookService.findBookByTitle("Wealth of Nations, The");
        assertThat(result.getTitle()).isEqualTo(book.getTitle());
        assertThat(result.getAuthor()).isEqualTo(book.getAuthor());
        assertThat(result.getPublisher()).isEqualTo(book.getPublisher());
        assertThat(result.getGenre()).isEqualTo(book.getGenre());
    }
}