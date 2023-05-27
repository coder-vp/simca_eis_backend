package com.simca.eis.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "designation")
    private String designation;

    @Column(name = "role")
    private String role;

    @Column(name = "create_time")
    private long createTime;

    @Column(name = "is_active")
    private boolean isActive;
}
