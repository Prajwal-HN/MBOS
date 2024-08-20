package com.curd.master.controller;

import com.curd.master.entity.AccountEntity;
import com.curd.master.model.AccountCreationRequest;
import com.curd.master.model.AccountUpdateRequest;
import com.curd.master.service.AccountService;
import com.curd.master.service.impl.AccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/v1/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    // POST - Create a new account
    @PostMapping("/createAccount")
    public AccountEntity createAccount(@RequestBody AccountCreationRequest accountCreationRequest) {
        log.info("Create account Request : {}", accountCreationRequest);
        return accountService.createAccount(accountCreationRequest);
    }

    // PUT - Update an existing account by ID
    @PutMapping("updateBalanceById/{id}")
    public AccountEntity updateAccount(@PathVariable Long id, @RequestBody AccountUpdateRequest accountUpdateRequest) {
        log.info("Update application Request : {} || id : {}", accountUpdateRequest, id);
        return accountService.updateAccount(id, accountUpdateRequest);
    }

    // GET - Get an account by ID
    @GetMapping("/{id}")
    public AccountEntity getAccount(@PathVariable Long id) {
        log.info("get Account by ID : {}", id);
        return accountService.getAccount(id);
    }

    // GET - Get all accounts
    @GetMapping("getAllAccount")
    public List<AccountEntity> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/")
    public List<AccountEntity> getAccountEntityByPageAndSize(@RequestParam("page") int pageNumber) {
        log.info("Page Number  : {}", pageNumber);
        return accountService.getAccountEntityByPageAndSize(pageNumber);
    }
}
