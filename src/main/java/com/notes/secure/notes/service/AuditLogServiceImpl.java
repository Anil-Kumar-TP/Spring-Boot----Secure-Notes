package com.notes.secure.notes.service;

import com.notes.secure.notes.model.AuditLog;
import com.notes.secure.notes.model.Note;
import com.notes.secure.notes.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuditLogServiceImpl implements AuditLogService{

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Override
    public void logNoteCreation(String username, Note note){
        AuditLog log = new AuditLog();
        log.setAction("CREATED");
        log.setUsername(username);
        log.setNoteId(note.getId());
        log.setNoteContent(note.getContent());
        log.setTimeStamp(LocalDateTime.now());
        auditLogRepository.save(log);
    }

    @Override
    public void logNoteUpdate(String username, Note note){
        AuditLog log = new AuditLog();
        log.setAction("UPDATED");
        log.setUsername(username);
        log.setNoteId(note.getId());
        log.setNoteContent(note.getContent());
        log.setTimeStamp(LocalDateTime.now());
        auditLogRepository.save(log);
    }

    @Override
    public void logNoteDelete(String username, Long noteId){
        AuditLog log = new AuditLog();
        log.setAction("DELETED");
        log.setUsername(username);
        log.setNoteId(noteId);
        log.setTimeStamp(LocalDateTime.now());
        auditLogRepository.save(log);
    }

    @Override
    public List<AuditLog> getAllAuditLogs() {
       return auditLogRepository.findAll();
    }

    @Override
    public List<AuditLog> getAuditLogsForNoteId(Long id) {
        return auditLogRepository.findByNoteId(id);
    }
}
