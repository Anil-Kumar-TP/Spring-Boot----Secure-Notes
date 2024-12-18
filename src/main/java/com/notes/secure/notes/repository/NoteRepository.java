package com.notes.secure.notes.repository;

import com.notes.secure.notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {
    List<Note> findByOwnerUsername(String ownerUsername);
}
