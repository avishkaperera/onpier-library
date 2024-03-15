package org.onpier.onpierlibrary.loader.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record Borrowing(
        @JsonProperty("Borrower")
        String borrower,
        @JsonProperty("Book")
        String book,
        @JsonProperty("borrowed from")
        @JsonFormat(pattern = "MM/dd/yyyy", shape = JsonFormat.Shape.STRING)
        LocalDate borrowedFrom,
        @JsonProperty("borrowed to")
        @JsonFormat(pattern = "MM/dd/yyyy", shape = JsonFormat.Shape.STRING)
        LocalDate borrowedTo) {
}
