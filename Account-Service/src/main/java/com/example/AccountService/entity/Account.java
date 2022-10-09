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
@Table(value="account")
@Getter
public class Account implements Serializable {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    @Column(value = "name")
    @Setter
    private String username;

    @Setter
    @Column(value = "email")
    private String email;

    @Setter
    @Column(value = "password")
    private String password;

    @Column(value = "created_at")
    private Date createdAt;

    @Column(value = "is_active")
    private Boolean active;


}
