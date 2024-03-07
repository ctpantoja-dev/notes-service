package com.ota.notesservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ota.notesservice.model.NoteEntity;

@Repository
public interface NoteRepository extends CrudRepository<NoteEntity, Integer> {

}
