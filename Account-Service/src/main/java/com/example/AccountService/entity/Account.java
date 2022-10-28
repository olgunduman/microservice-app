package com.example.AccountService.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Table(value="account_table")

@Getter
public class Account implements Serializable {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();


    @Setter
    private String username;


    @Setter
    private String name;


    @Setter
    private String surname;

    @Setter
    private String email;

    @Setter
    private Date birthDate;

    @Setter
    private String password;


    @Setter
    private Date createdAt;
    @Setter
    private Boolean active;


}
