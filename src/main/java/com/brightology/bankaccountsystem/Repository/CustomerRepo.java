package com.brightology.bankaccountsystem.Repository;

import com.brightology.bankaccountsystem.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Optional<Customer> findByFirstNameAndLastName(String firstName, String lastName);

}