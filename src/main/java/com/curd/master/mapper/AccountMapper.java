package com.curd.master.mapper;

import com.curd.master.entity.AccountEntity;
import com.curd.master.model.AccountCreationRequest;
import com.curd.master.model.AccountUpdateRequest;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AccountMapper {
    public AccountEntity mapToAccountEntity(AccountCreationRequest account) {
        return AccountEntity.builder()
                .name(account.getName())
                .email(account.getEmail())
                .mobileNumber(account.getMobileNumber())
                .balance(account.getBalance())
                .address(account.getAddress())
                .postCode(account.getPostCode())
                .updateDate(new Date())
                .accountCreationDate(new Date())
                .build();
    }

    public AccountEntity mapAccountEntityBalance(AccountEntity account, AccountUpdateRequest updatedAccount) {
        account.setBalance(updatedAccount.getBalance());
        account.setUpdateDate(new Date());
        return account;
    }
}
