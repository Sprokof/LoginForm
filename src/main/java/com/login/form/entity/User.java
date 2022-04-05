package com.login.form.entity;


import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "USERS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "USER_NAME")
    @Length(min = 5, max = 20, message = "*Your user name must be in range from 5 to 20 characters")
    @NotNull(message = "*Please provide a user name")
    private String userName;
    @Column(name = "EMAIL")
    @Email(message = "*Please provide a valid email")
    private String email;
    @Column(name = "USER_PASSWORD")
    @Length(min = 5, max = 30, message = "*Your password must be in range from 5 to 30 characters")
    @NotNull(message = "*Please provide a password")
    private String password;
    @Column(name = "FIRST_NAME")
    @NotNull(message = "*Please provide your name")
    private String name;
    @Column(name = "LAST_NAME")
    @NotNull(message = "*Please provide a your name")
    private String lastName;
    @Column(name = "IS_ACTIVE")
    private boolean is_active;
    @Column(name = "CODE")
    private String code;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;


}
