package org.onpier.onpierlibrary.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class User {

    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "MM/dd/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate memberSince;
    @JsonFormat(pattern = "MM/dd/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate memberTill;
    private String gender;
}
