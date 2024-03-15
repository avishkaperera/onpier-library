package org.onpier.onpierlibrary.persistence.repository;

import org.onpier.onpierlibrary.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findUserByFirstNameAndLastName(String firstName, String lastName);

    List<User> findByBorrowingsNotNull();

    // Fetches Users who are not terminated (member_till value is null) and
    // currently does not have any borrowings (borrowed_to value is greater than current date
    // indicating it is yet to be returned and currently borrowed)
    @Query(value = "SELECT u.* FROM \"USER\" u INNER JOIN BORROWING b on u.id = b.borrower_id " +
            "WHERE u.member_till IS NULL AND b.borrowed_to > CURRENT_DATE()",
            nativeQuery = true)
    List<User> findByMemberTillNotNullAndCurrentBorrowingsNull();
}
