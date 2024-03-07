package com.ota.notesservice.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.ota.notesservice.model.Note;
import com.ota.notesservice.service.NoteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    /**
     * Retrieves a specific note by ID
     * 
     * @param noteId
     */
    @GetMapping(value = "/{noteId}", produces = "application/json")
    public ResponseEntity<Note> getNote(@PathVariable int noteId) {
        if (noteId < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid noteId provided.");
        }

        Optional<Note> noteOpt = noteService.getNote(noteId);

        if (noteOpt.isPresent()) {
            return ResponseEntity.ok(noteOpt.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Note with noteId <" + noteId + "> not found.");
        }
    }

    /**
     * Retrieve all notes
     */
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> allNotes = noteService.getAllNotes();
        return ResponseEntity.ok().body(allNotes);
    }

    /**
     * Create a new note
     */
    @PostMapping(consumes = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createNote(@Valid @RequestBody Note note) {
        noteService.createNote(note);
    }

    /**
     * Update a specific note
     * 
     * @param noteId
     */
    @PutMapping(value = "/{noteId}", consumes = "application/json")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updateNote(@PathVariable int noteId, @Valid @RequestBody Note note) {
        if (noteId < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid noteId provided.");
        }

        if (noteService.noteExists(noteId)) {
            noteService.updateNote(noteId, note);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Note with noteId <" + noteId + "> not found.");
        }
    }

    /**
     * Delete a specific note
     * 
     * @param noteId
     */
    @DeleteMapping(value = "/{noteId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteNote(@PathVariable int noteId) {
        if (noteId < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid noteId provided.");
        }

        if (noteService.noteExists(noteId)) {
            noteService.deleteNote(noteId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Note with noteId <" + noteId + "> not found.");
        }
    }
}
