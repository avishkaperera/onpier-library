package org.onpier.onpierlibrary.api.controller;

import lombok.RequiredArgsConstructor;
import org.onpier.onpierlibrary.api.model.User;
import org.onpier.onpierlibrary.service.UserService;
import org.onpier.onpierlibrary.util.UserConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/library", produces = "application/json")
@RequiredArgsConstructor
public class LibraryController {

    private final UserService userService;

    @GetMapping("/borrowers")
    public ResponseEntity<List<User>> getBorrowers() {
        return ResponseEntity.ok(userService.findBorrowers().stream().map(UserConverter::toUserResponse).toList());
    }

    @GetMapping("/members/active/no-borrowings")
    public ResponseEntity<List<User>> getActiveNonBorrowers() {
        return ResponseEntity.ok(
                userService.findNonTerminatedNonBorrowers().stream()
                        .map(UserConverter::toUserResponse)
                        .toList());
    }
}
