package com.backend.apptive.repository;

import com.backend.apptive.domain.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findByNameAndPhoneNumber(String name, String phoneNumber);
}
