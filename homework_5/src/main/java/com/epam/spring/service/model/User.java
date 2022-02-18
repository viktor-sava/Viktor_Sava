package com.epam.spring.service.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String surname;

    private String name;

    private String patronymic;

    @Column(nullable = false, unique = true)
    private String email;

    private String phone;

    private String password;

    @Column(updatable = false)
    @CreationTimestamp
    private Timestamp createDate;

    private boolean blocked;

    private boolean admin;

}
