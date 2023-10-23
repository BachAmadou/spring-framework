package com.dev.controller;

import com.dev.model.Transaction;
import com.dev.service.AccountService;
import com.dev.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransactionController {

    private  final AccountService accountService;
    private final TransactionService transactionService;
    public TransactionController(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @GetMapping("/make-transfer")
    public String getMakeTransfer(Model model) {
        // get the empty transaction object
        model.addAttribute("transaction", Transaction.builder().build());

        // provide hte list of all account
        model.addAttribute("accounts", accountService.listAllAccount());

        // provide the list of last 10 transactions to fill the table
        model.addAttribute("lastTransactions", transactionService.last10Transactions());

        return "transaction/make-transfer";
    }
}
