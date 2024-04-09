package com.erkanoygn.estore.dto;

import com.erkanoygn.estore.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private List<Long> productIds;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private Gender gender;
    private String nationalId;
    private Long phoneNo;
    private Date birthDate;
    private String homeAddress;
}

