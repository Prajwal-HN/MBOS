package com.curd.master.service.impl;

import com.curd.master.entity.AccountEntity;
import com.curd.master.mapper.AccountMapper;
import com.curd.master.model.AccountCreationRequest;
import com.curd.master.model.AccountUpdateRequest;
import com.curd.master.repository.AccountRepository;
import com.curd.master.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository,
                              AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    // POST - Create a new account
    @Transactional
    public AccountEntity createAccount(AccountCreationRequest account) {
        AccountEntity accountEntity = accountMapper.mapToAccountEntity(account);
        log.info("Mapped Account Entity in Create Account : {}", accountEntity);

        AccountEntity saveEntityResponse = accountRepository.save(accountEntity);
        log.info("saveEntityResponse : {}", saveEntityResponse);
        return saveEntityResponse;
    }

    @Transactional
    public AccountEntity updateAccount(Long id, AccountUpdateRequest updatedAccount) {
        AccountEntity account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        AccountEntity accountEntity = accountMapper.mapAccountEntityBalance(account, updatedAccount);
        log.info("updateAccount response : {}", accountEntity);
        return accountRepository.save(accountEntity);
    }

    @Transactional(readOnly = true)  // Use readOnly for read operations
    public AccountEntity getAccount(Long id) {
        AccountEntity account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        log.info("getAccount by id response : {}", account);
        return account;
    }

    @Transactional(readOnly = true)
    public List<AccountEntity> getAllAccounts() {
        List<AccountEntity> accountEntityList = accountRepository.findAll();
        log.info("accountEntityList find all response : {}", accountEntityList);
        return accountEntityList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccountEntity> getAccountEntityByPageAndSize(int page) {
        List<AccountEntity> pageListEntity = accountRepository.findAll(PageRequest.of(page - 1, 10)).getContent();
        log.info("pageListEntity : {}", pageListEntity);
        return pageListEntity;
    }
}
