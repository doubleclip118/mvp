package com.backend.apptive.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<ASRequest> asRequests;

    @Builder
    public Customer(Long id, String name, String phoneNumber, List<ASRequest> asRequests) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.asRequests = asRequests;
    }
}
