package com.backend.apptive.controller;

import com.backend.apptive.DTO.CustomerResponseDTO;
import com.backend.apptive.service.CustomerService;
import com.backend.apptive.util.error.ApiResponse;
import com.backend.apptive.util.error.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final CustomerService customerService;

    @GetMapping("/user")
    public ResponseEntity<?> getCustomer(@RequestParam String name, @RequestParam String phoneNumber) {
        try {
            CustomerResponseDTO customerResponseDTO = customerService.getCustomerByNameAndPhoneNumber(name,phoneNumber);
            return ResponseEntity.ok(new ApiResponse<>("success", customerResponseDTO));
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("error", "Customer not found"));
        }
    }
}
