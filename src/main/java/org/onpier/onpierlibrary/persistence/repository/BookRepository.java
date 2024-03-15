package org.onpier.onpierlibrary.persistence.repository;

import org.onpier.onpierlibrary.persistence.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    Book findBookByTitle(String title);
}
