package com.notes.secure.notes.service;

import com.notes.secure.notes.model.Note;

public interface AuditLogService {
    void logNoteCreation(String username, Note note);

    void logNoteUpdate(String username, Note note);


    void logNoteDelete(String username, Long noteId);
}
