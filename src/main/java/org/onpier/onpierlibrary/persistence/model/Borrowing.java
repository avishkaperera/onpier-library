package org.onpier.onpierlibrary.persistence.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    private User borrower;
    @ManyToOne
    private Book book;
    @Column(name = "borrowedFrom")
    private LocalDate borrowedFrom;
    @Column(name = "borrowedTo")
    private LocalDate borrowedTo;
}
