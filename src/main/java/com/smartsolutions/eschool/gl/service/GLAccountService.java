package com.smartsolutions.eschool.gl.service;

import com.smartsolutions.eschool.gl.model.GLAccountEntity;
import com.smartsolutions.eschool.gl.repository.GLAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GLAccountService {

    private final GLAccountRepository glAccountRepository;

    public GLAccountEntity getAccountByCode(Long organizationId, String accountCode) {
        return glAccountRepository.findByOrganizationIdAndAccountCode(organizationId, accountCode)
                .orElseThrow(() -> new RuntimeException("Account not found: " + accountCode));
    }

    @Transactional
    public GLAccountEntity createAccount(GLAccountEntity account) {
        // Logic to calculate level based on parent
        if (account.getParent() != null) {
            GLAccountEntity parent = glAccountRepository.findById(account.getParent().getId())
                    .orElseThrow(() -> new RuntimeException("Parent account not found"));
            account.setLevel(parent.getLevel() + 1);
            account.setAccountType(parent.getAccountType()); // Inherit type
        } else {
            account.setLevel(1);
        }
        return glAccountRepository.save(account);
    }

    public List<GLAccountEntity> getChartOfAccounts(Long organizationId) {
        return glAccountRepository.findAllByOrganizationIdAndIsActiveTrue(organizationId);
    }
}
