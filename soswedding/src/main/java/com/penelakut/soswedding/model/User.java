package com.penelakut.soswedding.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProviderService> providerServices;

    private String imgUrl;

    private void addProviderService(ProviderService providerService){
        providerServices.add(providerService);
        providerService.setUser(this);
    }

    private void removeProviderService(ProviderService providerService){
        providerServices.remove(providerService);
        providerService.setUser(null);
    }


}
