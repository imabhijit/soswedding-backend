package com.penelakut.soswedding.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String uuid;

    @NotNull
    private String firstName;

    @NotNull
    private String emailAddress;

    @NotNull
    private UserType type;

    private String lastName;

    private String phoneNumber;

    private String companyName;

    private String imgUrl;

    private ServiceType serviceType;

}
