package com.dev.service;

import com.dev.enums.AccountType;
import com.dev.model.Account;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface AccountService {

    Account createNewAccount(BigDecimal balance, Date createDate, AccountType accountType, Long userId);
    List<Account> listAllAccount();
    void deleteAccount(UUID id);
    void activateAccount(UUID id);
}
