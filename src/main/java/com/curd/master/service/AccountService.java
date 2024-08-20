package com.curd.master.service;

import com.curd.master.entity.AccountEntity;
import com.curd.master.model.AccountCreationRequest;
import com.curd.master.model.AccountUpdateRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AccountService {
    AccountEntity createAccount(AccountCreationRequest accountCreationRequest);

    AccountEntity updateAccount(Long id, AccountUpdateRequest accountUpdateRequest);

    AccountEntity getAccount(Long id);

    List<AccountEntity> getAllAccounts();

    List<AccountEntity> getAccountEntityByPageAndSize(int page);
}
