package org.onpier.onpierlibrary.util;

import lombok.experimental.UtilityClass;
import org.onpier.onpierlibrary.persistence.model.Book;

@UtilityClass
public class BookConverter {

    public Book toBookEntity(org.onpier.onpierlibrary.loader.model.Book book){
        return Book.builder()
                .title(book.title())
                .author(book.author())
                .genre(book.genre())
                .publisher(book.publisher())
                .build();
    }
}
