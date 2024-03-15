package org.onpier.onpierlibrary.service;

import lombok.RequiredArgsConstructor;
import org.onpier.onpierlibrary.loader.model.User;
import org.onpier.onpierlibrary.persistence.repository.UserRepository;
import org.onpier.onpierlibrary.util.UserConverter;
import org.onpier.onpierlibrary.util.Validator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void saveUser(User user) {
        if (Validator.isUserNotEmpty(user)) {
            userRepository.save(UserConverter.toUserEntity(user));
        }
    }

    public org.onpier.onpierlibrary.persistence.model.User findUserByBorrower(String borrower) {
        String[] split = borrower.split(",");
        return userRepository.findUserByFirstNameAndLastName(split[1], split[0]);
    }

    public List<org.onpier.onpierlibrary.persistence.model.User> findBorrowers() {
        return userRepository.findByBorrowingsNotNull();
    }

    public List<org.onpier.onpierlibrary.persistence.model.User> findNonTerminatedNonBorrowers() {
        return userRepository.findByMemberTillNotNullAndCurrentBorrowingsNull();
    }
}
