package com.ota.notesservice.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Note {

    private int id;
    @NotNull(message = "Note title is required.")
    @NotEmpty(message = "Note title must not be empty.")
    private String title;

    @NotNull(message = "Note body is required")
    @NotEmpty(message = "Note body must not be empty.")
    private String body;

    public Note() {}

    public Note(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return this.body;
    }
}
