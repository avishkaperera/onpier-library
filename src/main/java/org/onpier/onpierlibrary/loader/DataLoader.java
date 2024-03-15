package org.onpier.onpierlibrary.loader;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.RequiredArgsConstructor;
import org.onpier.onpierlibrary.loader.model.Book;
import org.onpier.onpierlibrary.loader.model.Borrowing;
import org.onpier.onpierlibrary.loader.model.User;
import org.onpier.onpierlibrary.service.BookService;
import org.onpier.onpierlibrary.service.BorrowingService;
import org.onpier.onpierlibrary.service.UserService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader {

    private final CsvMapper csvMapper;
    private final BookService bookService;
    private final UserService userService;
    private final BorrowingService borrowingService;

    @EventListener(ApplicationReadyEvent.class)
    private void onAppStartLoad(ApplicationReadyEvent event) throws IOException {
        List<Book> books = loadData(Book.class, "/books.csv");
        books.forEach(bookService::saveBook);
        List<User> users = loadData(User.class, "/user.csv");
        users.forEach(userService::saveUser);
        List<Borrowing> borrowings = loadData(Borrowing.class, "/borrowed.csv");
        borrowings.forEach(borrowingService::saveBorrowing);
    }

    private <T> List<T> loadData(Class<T> type, String fileName) throws IOException {
        try (InputStream input = getClass().getResourceAsStream(fileName)) {
            CsvSchema schema = CsvSchema.emptySchema().withHeader();
            MappingIterator<T> iterator = csvMapper.readerWithSchemaFor(type).with(schema).readValues(input);
            return iterator.readAll();
        } catch (Exception ex) {
            System.out.println("Reading from the file failed.");
            return Collections.emptyList();
        }
    }
}
