package com.dev.service;

import com.dev.enums.AccountType;
import com.dev.model.Account;
import com.dev.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AccountServiceImpl implements AccountService{

    AccountRepository accountRepository;
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createNewAccount(BigDecimal balance, Date createDate, AccountType accountType, Long userId) {
        // create account object
        Account account  = Account.builder().id(UUID.randomUUID()).userId(userId)
                .balance(balance).accountType(accountType).creationDate(createDate).build();

        // save into the database(repository)


        // return the object created

        return accountRepository.save(account);
    }

    @Override
    public List<Account> listAllAccount() {

        return accountRepository.findAll();
    }
}



























