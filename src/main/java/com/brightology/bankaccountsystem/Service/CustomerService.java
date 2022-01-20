package com.brightology.bankaccountsystem.Service;

import com.brightology.bankaccountsystem.Model.CheckingAccount;
import com.brightology.bankaccountsystem.Model.Customer;
import com.brightology.bankaccountsystem.Model.SavingAccount;
import com.brightology.bankaccountsystem.Repository.CheckingAccountRepo;
import com.brightology.bankaccountsystem.Repository.CustomerRepo;
import com.brightology.bankaccountsystem.Repository.SavingAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private CheckingAccountRepo checkingAccountRepo;
    @Autowired
    private SavingAccountRepo savingAccountRepo;


    public List<Customer> getAll() {
        return customerRepo.findAll();
    }

    public Customer getId(Integer findById){
        return customerRepo.findById(findById).get();
        //orElseThrow(() -> new ApiRequestException("Id does not exist. Please try again."));
    }

    public Customer newSavingAccount(String firstName, String lastName, Integer addingBalance) {

        SavingAccount savingAccount = new SavingAccount();
        savingAccount.setBalance(addingBalance);
        savingAccount.setAddorMinusBalance(addingBalance);
        savingAccount.setNewBalance(addingBalance);
        savingAccount.setStatus("active");

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setFirstSavingAmount(addingBalance);
        customer.setStatus("active");

        customer.setSavingAccount(Arrays.asList(savingAccount));

        return customerRepo.save(customer);
    }

    public Customer newCheckingAccount(String firstName, String lastname, Integer addingBalance) {

        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.setBalance(addingBalance);
        checkingAccount.setAddOrMinusBalance(addingBalance);
        checkingAccount.setNewBalance(addingBalance);
        checkingAccount.setStatus("active");

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastname);
        customer.setFirstCheckingAmount(addingBalance);
        customer.setStatus("active");

        customer.setCheckingAccount(Arrays.asList(checkingAccount));

        return customerRepo.save(customer);

        //customerRepo.findByFirstNameAndLastName(firstName,lastname).get();
    }

    public Customer newCheckingNSavingAccount(String firstName, String lastname, Integer addingBalanceChecking, Integer addingBalanceSaving) {

        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.setBalance(addingBalanceChecking);
        checkingAccount.setAddOrMinusBalance(addingBalanceChecking);
        checkingAccount.setNewBalance(addingBalanceChecking);
        checkingAccount.setStatus("active");

        SavingAccount savingAccount = new SavingAccount();
        savingAccount.setBalance(addingBalanceSaving);
        savingAccount.setAddorMinusBalance(addingBalanceSaving);
        savingAccount.setNewBalance(addingBalanceSaving);
        savingAccount.setStatus("active");


        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastname);
        customer.setFirstSavingAmount(addingBalanceSaving);
        customer.setFirstCheckingAmount(addingBalanceChecking);
        customer.setStatus("active");

        customer.setCheckingAccount(Arrays.asList(checkingAccount));
        customer.setSavingAccount(Arrays.asList(savingAccount));


        return customerRepo.save(customer);

    }

//    public String closeAccount(Integer id) {
//
//        Customer customer = customerRepo.findById(id).get();
//        //orElseThrow(() -> new ApiRequestException("Customer does not exist. Please try again."));
//        customer.setStatus("inactive");
//
//        CheckingAccount checkingAccount = checkingAccountRepo.findByCustomerId(id).get();
//        checkingAccount.setBalance(null);
//        checkingAccount.setAddOrMinusBalance(null);
//        checkingAccount.setNewBalance(null);
//        checkingAccount.setStatus("inactive");
//
//        SavingAccount savingAccount = savingAccountRepo.findByCustomerId(id).get();
//        savingAccount.setBalance(0);
//        savingAccount.setAddorMinusBalance(0);
//        savingAccount.setNewBalance(0);
//        savingAccount.setStatus("inactive");
//
//        customerRepo.save(customer);
//        checkingAccountRepo.save(checkingAccount);
//        savingAccountRepo.save(savingAccount);
//
//        return "Accounts Closed";
//    }

    public Customer findByFullName(String firstName, String lastName){
        return customerRepo.findByFirstNameAndLastName(firstName,lastName).get();
        //.orElseThrow(() -> new ApiRequestException("Name does not exist. Please check and try again."));
    }

}

