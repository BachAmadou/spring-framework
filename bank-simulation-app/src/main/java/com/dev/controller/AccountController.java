package com.dev.controller;

import com.dev.enums.AccountType;
import com.dev.model.Account;
import com.dev.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/index")
    public String getIndexPage(Model model) {

        model.addAttribute("accountList", accountService.listAllAccount());

        return "account/index";
    }

    @GetMapping("/create-form")
    public String createAccount(Model model) {
        // we need to provide an empty account object
        model.addAttribute("account", Account.builder().build());

        // we need to provide account type from enum to fill the dropdown options
        model.addAttribute("accountTypes", AccountType.values());

        return "account/create-account";
    }
}
