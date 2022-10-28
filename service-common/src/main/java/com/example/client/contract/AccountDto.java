package com.example.client.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private String id;
    private String username;
    private String name;
    private String surname;
    private String email;

    private Date birthDate;

    public String getNameSurname(){
        return name + " " + surname;
    }
}
