package org.onpier.onpierlibrary.persistence.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.CascadeType.ALL;

@Data
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "member_since")
    private LocalDate memberSince;
    @Column(name = "member_till")
    private LocalDate memberTill;
    @Column(name = "gender")
    private String gender;
    @OneToMany(mappedBy = "borrower", cascade = ALL)
    private List<Borrowing> borrowings;
}
