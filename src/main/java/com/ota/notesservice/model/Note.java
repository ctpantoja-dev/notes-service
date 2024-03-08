package com.ota.notesservice.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Note {

    private int id;
    @NotNull(message = "Note title is required.")
    @NotEmpty(message = "Note title must not be empty.")
    private String title;

    @NotNull(message = "Note body is required")
    @NotEmpty(message = "Note body must not be empty.")
    private String body;
}
