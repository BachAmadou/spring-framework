package com.dev;

import com.dev.enums.AccountType;
import com.dev.model.Account;
import com.dev.service.AccountService;
import com.dev.service.TransactionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class BankSimulationAppApplication {
	public static void main(String[] args) {
	    ApplicationContext container = SpringApplication.run(BankSimulationAppApplication.class, args);

//		//get account and transaction service beans
//		AccountService accountService = container.getBean(AccountService.class);
//		TransactionService transactionService = container.getBean(TransactionService.class);
//
//		//create 2 accounts sender and receiver
//		Account sender = accountService.createNewAccount(BigDecimal.valueOf(70), new Date(), AccountType.SAVING, 1L);
//		Account receiver = accountService.createNewAccount(BigDecimal.valueOf(50), new Date(), AccountType.CHECKING, 2L);
//		Account receiver2 = accountService.createNewAccount(BigDecimal.valueOf(5450), new Date(), AccountType.CHECKING, 12L);
//		Account receiver3 = accountService.createNewAccount(BigDecimal.valueOf(340), new Date(), AccountType.SAVING, 21L);
//		Account receiver2 = null;
//
//		accountService.listAllAccount().forEach(System.out::println);
//
//		transactionService.makeTransfer(sender, receiver, new BigDecimal(30), new Date(), "Transaction 1");
//
//		System.out.println(transactionService.findAllTransaction().get(0));
//
//		accountService.listAllAccount().forEach(System.out::println);

	}




















}
