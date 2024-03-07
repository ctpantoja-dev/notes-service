package com.ota.notesservice.service;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.ota.notesservice.model.Note;
import com.ota.notesservice.model.NoteEntity;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    Note entityToDto(NoteEntity entity);

    @Mapping(target = "id", ignore = true)
    NoteEntity dtoToEntity(Note dto);

    List<Note> entityListToDtoList(List<NoteEntity> entity);

    List<NoteEntity> dtoListToEntityList(List<Note> dto);
}
