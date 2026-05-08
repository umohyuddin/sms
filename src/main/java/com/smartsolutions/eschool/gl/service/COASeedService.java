package com.smartsolutions.eschool.gl.service;

import com.smartsolutions.eschool.gl.enums.AccountType;
import com.smartsolutions.eschool.gl.enums.BalanceSide;
import com.smartsolutions.eschool.gl.model.GLAccountEntity;
import com.smartsolutions.eschool.gl.repository.GLAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class COASeedService {

    private final GLAccountRepository glAccountRepository;

    @Transactional
    public void seedInitialCOA(Long organizationId) {
        // LEVEL 1: Main Categories
        GLAccountEntity assets = createAccount(organizationId, "1000", "Assets", null, AccountType.ASSET, true, BalanceSide.DEBIT);
        GLAccountEntity liabilities = createAccount(organizationId, "2000", "Liabilities", null, AccountType.LIABILITY, true, BalanceSide.CREDIT);
        GLAccountEntity equity = createAccount(organizationId, "3000", "Equity", null, AccountType.EQUITY, true, BalanceSide.CREDIT);
        GLAccountEntity income = createAccount(organizationId, "4000", "Income", null, AccountType.INCOME, true, BalanceSide.CREDIT);
        GLAccountEntity expenses = createAccount(organizationId, "5000", "Expenses", null, AccountType.EXPENSE, true, BalanceSide.DEBIT);

        // ASSETS Sub-categories
        GLAccountEntity currentAssets = createAccount(organizationId, "1100", "Current Assets", assets, AccountType.ASSET, true, BalanceSide.DEBIT);
        createAccount(organizationId, "1111", "Cash in Hand", currentAssets, AccountType.ASSET, false, BalanceSide.DEBIT);
        createAccount(organizationId, "1113", "Bank - Main Account", currentAssets, AccountType.ASSET, false, BalanceSide.DEBIT);
        
        GLAccountEntity receivables = createAccount(organizationId, "1120", "Accounts Receivable", currentAssets, AccountType.ASSET, true, BalanceSide.DEBIT);
        GLAccountEntity studentReceivable = createAccount(organizationId, "1121", "Student Fee Receivable", receivables, AccountType.ASSET, false, BalanceSide.DEBIT);
        studentReceivable.setControlAccount(true);
        glAccountRepository.save(studentReceivable);

        // INCOME Sub-categories
        GLAccountEntity academicRevenue = createAccount(organizationId, "4100", "Academic Revenue", income, AccountType.INCOME, true, BalanceSide.CREDIT);
        createAccount(organizationId, "4110", "Tuition Fee", academicRevenue, AccountType.INCOME, false, BalanceSide.CREDIT);
        createAccount(organizationId, "4120", "Admission Fee", academicRevenue, AccountType.INCOME, false, BalanceSide.CREDIT);

        // EXPENSES Sub-categories
        GLAccountEntity payrollExpenses = createAccount(organizationId, "5100", "Payroll Expenses", expenses, AccountType.EXPENSE, true, BalanceSide.DEBIT);
        createAccount(organizationId, "5110", "Teacher Salaries", payrollExpenses, AccountType.EXPENSE, false, BalanceSide.DEBIT);
    }

    private GLAccountEntity createAccount(Long orgId, String code, String name, GLAccountEntity parent, AccountType type, boolean isGroup, BalanceSide balance) {
        if (glAccountRepository.findByOrganizationIdAndAccountCode(orgId, code).isPresent()) {
            return glAccountRepository.findByOrganizationIdAndAccountCode(orgId, code).get();
        }

        GLAccountEntity account = new GLAccountEntity();
        account.setOrganizationId(orgId);
        account.setAccountCode(code);
        account.setAccountName(name);
        account.setParent(parent);
        account.setAccountType(type);
        account.setGroup(isGroup);
        account.setNormalBalance(balance);
        account.setLevel(parent == null ? 1 : parent.getLevel() + 1);
        account.setActive(true);
        
        return glAccountRepository.save(account);
    }
}
