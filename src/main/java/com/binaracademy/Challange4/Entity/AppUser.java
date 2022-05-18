package com.binaracademy.Challange4.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "email")
    private  String  email;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
}
