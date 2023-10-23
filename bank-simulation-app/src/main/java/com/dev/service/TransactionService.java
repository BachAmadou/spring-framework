package com.dev.service;

import com.dev.model.Account;
import com.dev.model.Transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TransactionService {

    Transaction makeTransfer(Account sender, Account receiver, BigDecimal amount, Date createDate, String message);
    List<Transaction> findAllTransaction();
    List<Transaction> last10Transactions();
}
