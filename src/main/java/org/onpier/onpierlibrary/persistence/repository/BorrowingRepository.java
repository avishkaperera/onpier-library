package org.onpier.onpierlibrary.persistence.repository;

import org.onpier.onpierlibrary.persistence.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BorrowingRepository extends JpaRepository<Borrowing, UUID> {
}
