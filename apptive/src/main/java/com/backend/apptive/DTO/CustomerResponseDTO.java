package com.backend.apptive.DTO;

import com.backend.apptive.DTO.ASRequestResponseDTO;
import com.backend.apptive.domain.ASRequest;
import com.backend.apptive.domain.Customer;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponseDTO {
    private String name;
    private String phoneNumber;
    private List<ASRequestResponseDTO> asList;

    @Builder
    public CustomerResponseDTO(String name, String phoneNumber, List<ASRequestResponseDTO> asList){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.asList = asList;
    }

    public static CustomerResponseDTO fromEntity(Customer customer) {
        return CustomerResponseDTO.builder()
            .name(customer.getName())
            .phoneNumber(customer.getPhoneNumber())
            .asList(customer.getAsRequests().stream()
                .map(ASRequestResponseDTO::fromEntity)
                .collect(Collectors.toList()))
            .build();
    }

    public Customer toEntity() {
        return Customer.builder()
            .name(this.name)
            .phoneNumber(this.phoneNumber)
            .asRequests(this.asList.stream()
                .map(ASRequestResponseDTO::toEntity)
                .collect(Collectors.toList()))
            .build();
    }
}
