package com.smartsolutions.eschool.gl.service;

import com.smartsolutions.eschool.gl.enums.JournalEntryStatus;
import com.smartsolutions.eschool.gl.model.JournalEntryEntity;
import com.smartsolutions.eschool.gl.model.JournalEntryLineEntity;
import com.smartsolutions.eschool.gl.repository.JournalEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class JournalEntryService {

    private final JournalEntryRepository journalEntryRepository;

    @Transactional
    public JournalEntryEntity postJournalEntry(JournalEntryEntity entry) {
        validateEntry(entry);
        entry.setStatus(JournalEntryStatus.POSTED);
        return journalEntryRepository.save(entry);
    }

    private void validateEntry(JournalEntryEntity entry) {
        BigDecimal totalDebit = BigDecimal.ZERO;
        BigDecimal totalCredit = BigDecimal.ZERO;

        if (entry.getLines().isEmpty()) {
            throw new RuntimeException("Journal entry must have at least one line");
        }

        for (JournalEntryLineEntity line : entry.getLines()) {
            if (line.getAccount().isGroup()) {
                throw new RuntimeException("Cannot post to a group account: " + line.getAccount().getAccountCode());
            }
            totalDebit = totalDebit.add(line.getDebit() != null ? line.getDebit() : BigDecimal.ZERO);
            totalCredit = totalCredit.add(line.getCredit() != null ? line.getCredit() : BigDecimal.ZERO);
        }

        if (totalDebit.compareTo(totalCredit) != 0) {
            throw new RuntimeException("Journal entry is not balanced. Total Debit: " + totalDebit + ", Total Credit: " + totalCredit);
        }
    }
}
