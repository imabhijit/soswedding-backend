package com.penelakut.soswedding.model;

import java.util.Set;
import java.util.UUID;

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
    private UUID uuid;

    @NotNull
    private String firstName;

    private String lastName;

    @NotNull
    private UserType type;

    private String phoneNumber;

    @NotNull
    private String emailAddress;

    private String companyName;

    private String imgUrl;

    private Set<ServiceType> serviceTypes;

//    TODO: Allow for many services via join table
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ProviderService> providerServices;

}
