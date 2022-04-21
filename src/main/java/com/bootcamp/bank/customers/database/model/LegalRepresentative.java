package com.bootcamp.bank.customers.database.model;

import lombok.Data;

@Data
public class LegalRepresentative {

    private String fullName;
    private String docNumber;
    private String phoneNumber;
    private String email;
    private String creationDate;
}
