package org.onpier.onpierlibrary.loader.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record User(
        @JsonProperty("Name")
        String lastName,
        @JsonProperty("First name")
        String firstName,
        @JsonProperty("Member since")
        @JsonFormat(pattern = "MM/dd/yyyy", shape = JsonFormat.Shape.STRING)
        LocalDate memberSince,
        @JsonProperty("Member till")
        @JsonFormat(pattern = "MM/dd/yyyy", shape = JsonFormat.Shape.STRING)
        LocalDate memberTill,
        @JsonProperty("Gender")
        String gender) {
}
