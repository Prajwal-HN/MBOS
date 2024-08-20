package com.curd.master.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountCreationRequest {
    private String name;
    private String email;
    private String mobileNumber;
    private String address;
    private String postCode;
    private Double balance;
}
