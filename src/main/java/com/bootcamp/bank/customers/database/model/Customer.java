package com.bootcamp.bank.customers.database.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(value = "customers")
public class Customer {

    @Id
    private String id;
    private Number type;
    @Indexed(unique = true)
    private String docNumber;
    private String ownerFirstName;
    private String ownerLastName;
    private String ownerLastName2;
    private String affiliationDate;
    private String phoneNumber;
    private String email;
    private Set<LegalRepresentative> legalRepresentatives;

}
