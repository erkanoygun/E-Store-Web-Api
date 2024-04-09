package com.erkanoygn.estore.entitiy;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String nationalId;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;
    private String homeAdress;

}
