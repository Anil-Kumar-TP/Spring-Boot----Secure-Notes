package com.notes.secure.notes.repository;

import com.notes.secure.notes.model.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog,Long> {
    List<AuditLog> findByNoteId(Long id);
}
