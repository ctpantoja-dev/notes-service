package com.ota.notesservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;
import com.ota.notesservice.model.Note;
import com.ota.notesservice.model.NoteEntity;
import com.ota.notesservice.repository.NoteRepository;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    public boolean noteExists(int noteId) {
        return noteRepository.existsById(noteId);
    }

    public Optional<Note> getNote(int noteId) {
        final Optional<NoteEntity> noteEntityOpt = noteRepository.findById(noteId);
        return noteEntityOpt.map(this::entityToDto);
    }

    public List<Note> getAllNotes() {
        final Iterable<NoteEntity> notesEntityList = noteRepository.findAll();
        return StreamSupport.stream(notesEntityList.spliterator(), false).map(this::entityToDto)
                .toList();
    }

    public void deleteNote(int noteId) {
        noteRepository.deleteById(noteId);
    }

    public void createNote(Note note) {
        final NoteEntity noteEntity = this.dtoToEntity(note);
        noteRepository.save(noteEntity);
    }

    public void updateNote(int noteId, Note note) {
        final Optional<NoteEntity> noteEntityOpt = noteRepository.findById(noteId);

        noteEntityOpt.ifPresent(entity -> {
            entity.setTitle(note.getTitle());
            entity.setBody(note.getBody());
            noteRepository.save(entity);
        });
    }

    private NoteEntity dtoToEntity(Note noteDto) {
        return NoteEntity.builder().title(noteDto.getTitle()).body(noteDto.getBody()).build();
    }

    private Note entityToDto(NoteEntity noteEntity) {
        return Note.builder().id(noteEntity.getId()).title(noteEntity.getTitle())
                .body(noteEntity.getBody()).build();
    }
}
