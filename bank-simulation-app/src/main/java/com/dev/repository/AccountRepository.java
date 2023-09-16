package com.dev.repository;

import com.dev.exception.RecordNotFoundException;
import com.dev.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class AccountRepository {

    public static List<Account> accountList = new ArrayList<>();

    public Account save(Account account) {
        accountList.add(account);
        return account;
    }

    public List<Account> findAll() {
        return accountList;
    }

    public Account findById(UUID id) {
        // complete the method that finds the account inside the list, if not throw RecordNotFoundException
        return accountList.stream()
                .filter(account -> account.getId().equals(id))
                .findAny().orElseThrow(() -> new RecordNotFoundException("Account does not exist in the database"));
    }
}

























