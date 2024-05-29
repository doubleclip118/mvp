package com.backend.apptive.service;

import com.backend.apptive.DTO.CustomerResponseDTO;
import com.backend.apptive.domain.Customer;
import com.backend.apptive.repository.UserRepository;
import com.backend.apptive.util.error.CustomerNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    private final UserRepository userRepository;

    public CustomerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public CustomerResponseDTO getCustomerByNameAndPhoneNumber(String name, String phoneNumber) {
        Customer customer = userRepository.findByNameAndPhoneNumber(name, phoneNumber)
            .orElseThrow(() -> new CustomerNotFoundException("Customer not found with name: " + name + " and phone number: " + phoneNumber));
        return CustomerResponseDTO.fromEntity(customer);
    }
}
