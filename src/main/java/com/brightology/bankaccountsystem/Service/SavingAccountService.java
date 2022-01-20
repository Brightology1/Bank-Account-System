package com.brightology.bankaccountsystem.Service;

import com.brightology.bankaccountsystem.Model.SavingAccount;
import com.brightology.bankaccountsystem.Repository.SavingAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingAccountService {

    @Autowired
    private SavingAccountRepo savingAccountRepo;

    public List<SavingAccount> allSavingAccounts(){
        return savingAccountRepo.findAll();
    }

    public SavingAccount getAccount(Integer findById){
        SavingAccount savingAccount = savingAccountRepo.findById(findById).get();
        return  savingAccount;
    }

    public SavingAccount withdrawal(Integer id ,Integer minusBalance){

        SavingAccount savingAccount = savingAccountRepo.findById(id).get();
        int balance = savingAccount.getBalance();
        int newBalance = balance - minusBalance;
        savingAccount.setAddorMinusBalance(minusBalance);
        savingAccount.setBalance(balance);
        savingAccount.setNewBalance(newBalance);

        savingAccountRepo.save(savingAccount);

        return savingAccountRepo.findById(id).get();
    }

    public SavingAccount deposit(Integer id,Integer addBalance){

        SavingAccount savingAccount=savingAccountRepo.findById(id).get();
        int balance = savingAccount.getBalance();
        int newBalance = balance + addBalance;
        savingAccount.setAddorMinusBalance(addBalance);
        savingAccount.setBalance(balance);
        savingAccount.setNewBalance(newBalance);
        savingAccountRepo.save(savingAccount);

        return savingAccountRepo.findById(id).get();
    }

    public SavingAccount closeAccount(Integer id){
        SavingAccount savingAccount = savingAccountRepo.findById(id).get();
        savingAccount.setAddOrMinusBalance(null);
        savingAccount.setAddOrMinusBalance(null);
        savingAccount.setNewBalance(null);
        savingAccount.setBalance(null);
        savingAccount.setStatus("inactive");
        savingAccountRepo.save(savingAccount);
        return savingAccount;
    }
}

