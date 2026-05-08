package com.smartsolutions.eschool.gl.repository;

import com.smartsolutions.eschool.gl.model.JournalEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepository extends JpaRepository<JournalEntryEntity, Long> {
}
