package com.brightology.bankaccountsystem.Service;

import com.brightology.bankaccountsystem.Model.CheckingAccount;
import com.brightology.bankaccountsystem.Repository.CheckingAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckingService {

    @Autowired
    private CheckingAccountRepo checkingAccountRepo;

    public List<CheckingAccount> allCheckingAccounts() {

        return checkingAccountRepo.findAll();
    }

    public CheckingAccount getAccount(Integer id){
        CheckingAccount checkingAccount= checkingAccountRepo.findById(id).get();
        //orElseThrow(() -> new ApiRequestException("Account does not exist. Please try again."));
        return checkingAccount;
    }

    public CheckingAccount withdrawal(Integer id,Integer minusBalance){

        CheckingAccount checkingAccount=checkingAccountRepo.findById(id).get();
        int balance = checkingAccount.getNewBalance();
        int newBalance = balance - minusBalance;
        checkingAccount.setBalance(balance);
        checkingAccount.setAddOrMinusBalance(minusBalance);
        checkingAccount.setNewBalance(newBalance);
        checkingAccountRepo.save(checkingAccount);

        return checkingAccountRepo.findById(id).get();
        //orElseThrow(() -> new ApiRequestException("Account does not exist. Please try again."));
    }

    public CheckingAccount deposit(Integer id,Integer addBalance){

        CheckingAccount checkingAccount=checkingAccountRepo.findById(id).get();
        int balance = checkingAccount.getNewBalance();
        int newBalance = balance + addBalance;
        checkingAccount.setAddOrMinusBalance(addBalance);
        checkingAccount.setBalance(balance);
        checkingAccount.setNewBalance(newBalance);
        checkingAccountRepo.save(checkingAccount);

        return checkingAccountRepo.findById(id).get();
        //orElseThrow(() -> new ApiRequestException("Account does not exist. Please try again."));
    }

    public CheckingAccount closeAccount(Integer id){
        CheckingAccount checkingAccount = checkingAccountRepo.findById(id).get();
        //orElseThrow(()-> new ApiRequestException("Account does not exist. Please try again."));
        checkingAccount.setAddOrMinusBalance(null);
        checkingAccount.setAddOrMinusBalance(null);
        checkingAccount.setNewBalance(null);
        checkingAccount.setBalance(null);
        checkingAccount.setStatus("inactive");
        checkingAccountRepo.save(checkingAccount);

        return checkingAccount;
    }


}
