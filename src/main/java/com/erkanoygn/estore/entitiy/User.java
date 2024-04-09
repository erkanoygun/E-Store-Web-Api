package com.erkanoygn.estore.entitiy;

import com.erkanoygn.estore.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "user_product",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @Column(name="first_name", length=100, nullable=false)
    private String firstName;

    @Column(name="last_name", length=100, nullable=false)
    private String lastName;

    @Column(name="username", length=15, nullable=false, unique = true)
    private String userName;

    @Column(name="password",nullable=false)
    @Size(min = 6, message = "Password must be at least 8 characters long")
    private String password;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @Column(name="gender", nullable=true)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name="national_id", length=11, nullable=false, unique = true)
    private String nationalId;

    @Column(name="phone_no", length=13, nullable=true, unique = true)
    private Long phoneNo;

    @Column(name="birth_day")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name="home_address", length=200)
    private String homeAddress;

}
