package org.onpier.onpierlibrary.loader.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Book(
        @JsonProperty("Title")
        String title,
        @JsonProperty("Author")
        String author,
        @JsonProperty("Genre")
        String genre,
        @JsonProperty("Publisher")
        String publisher) {
}
