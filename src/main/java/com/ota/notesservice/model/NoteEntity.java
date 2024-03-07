package com.ota.notesservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "notes")
public class NoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String title;
    @NotNull
    private String body;

    public NoteEntity() {}

    public NoteEntity(int id, String title, String body) {
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
