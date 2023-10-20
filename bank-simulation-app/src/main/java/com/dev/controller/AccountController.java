package com.dev.controller;

import com.dev.enums.AccountType;
import com.dev.model.Account;
import com.dev.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.UUID;


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

    @PostMapping("/create")
    // we use @ModelAttribute("account") to get the account from the above createAccount method
    public String AddAccount(@ModelAttribute("account") Account account, Model model) {
        System.out.println(account);
        accountService.createNewAccount(account.getBalance(),new Date(),account.getAccountType(),account.getUserId());
        return "redirect:/index";
    }
    @GetMapping("/delete/{id}")
    public String deleteAccount(@PathVariable("id")UUID id) {
        accountService.deleteAccount(id);
        return "redirect:index";
    }
}
