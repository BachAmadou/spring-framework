package com.dev.service;

import com.dev.enums.AccountType;
import com.dev.exception.AccountOwnershipException;
import com.dev.exception.BadRequestException;
import com.dev.exception.BalanceNotSufficientException;
import com.dev.model.Account;
import com.dev.model.Transaction;
import com.dev.repository.AccountRepository;
import com.dev.repository.TransactionRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction makeTransfer(Account sender, Account receiver, BigDecimal amount, Date createDate, String message) {

        /*
        * - if sender or receiver is null?
        * - if sender and receiver is the same account?
        * - if sender has enough balance to make the transfer?
        * - if both the accounts are checking, if not one of them saving, it needs to be same Userid
        * */

        validateAccount(sender, receiver);
        checkAccountOwnership(sender, receiver);
        executeBalanceAndUpdateIfRequired(amount, sender, receiver);

        // after all validations are completed, and money is transferred, we need to create transaction object and save/return it
        Transaction transaction = Transaction.builder().amount(amount).sender(sender.getId())
                .receiver(receiver.getId()).createDate(createDate).message(message).build();

        // makeTransfer
        return transactionRepository.save(transaction);
    }

    private void executeBalanceAndUpdateIfRequired(BigDecimal amount, Account sender, Account receiver) {
        if (checkSenderBalance(sender, amount)) {
            // update sender and receiver balance
            sender.setBalance(sender.getBalance().subtract(amount));
            receiver.setBalance(receiver.getBalance().add(amount));
        } else {
            throw new BalanceNotSufficientException("Balance is not enough for this transfer");
        }
    }

    private boolean checkSenderBalance(Account sender, BigDecimal amount) {
        // verify if the sender has enough balance to be able to send
        return sender.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) >= 0;
    }

    private void checkAccountOwnership(Account sender, Account receiver) {
        // check if one of the account is saving, and user of sender or receiver is not the same, throw AccountOwnershipException
        if ((sender.getAccountType().equals(AccountType.SAVING) || receiver.getAccountType().equals(AccountType.SAVING))
            && !sender.getUserId().equals(receiver.getUserId())) {
            throw  new AccountOwnershipException("If one of the account is saving, user must be the same for the sender and the receiver ");
        }
    }

    private void validateAccount(Account sender, Account receiver) {

//        -if any of the account is null.
//        - if account ids are the same (same account)
//        - if the account exist in the database(repository)


        if (sender == null || receiver == null) {
            throw new BadRequestException("Sender or Receiver cannot be null");
        }

        if (sender.getId().equals(receiver.getId())) {
            throw new BadRequestException("Sender account must be different from the Receiver account");
        }
        
        findAccountById(sender.getId());
        findAccountById(receiver.getId());
    }

    private void findAccountById(UUID id) {
        accountRepository.findById(id);
    }

    @Override
    public List<Transaction> findAllTransaction() {
        return null;
    }
}






















