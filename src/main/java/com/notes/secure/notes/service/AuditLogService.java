package com.notes.secure.notes.service;

import com.notes.secure.notes.model.AuditLog;
import com.notes.secure.notes.model.Note;

import java.util.List;

public interface AuditLogService {
    void logNoteCreation(String username, Note note);

    void logNoteUpdate(String username, Note note);


    void logNoteDelete(String username, Long noteId);

    List<AuditLog> getAllAuditLogs();

    List<AuditLog> getAuditLogsForNoteId(Long id);
}
