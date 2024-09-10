package com.greem4.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users", schema = "public")
public class User {

    @Id
    private String username;
    private String firstname;
    private String lastName;

    @Column(name = "birth_date")
    private Birthday birthday;

    @Enumerated(EnumType.STRING)
    private Role role;


}
