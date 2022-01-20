package com.brightology.bankaccountsystem.Repository;

import com.brightology.bankaccountsystem.Model.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckingAccountRepo extends JpaRepository<CheckingAccount,Integer> {
    public List<CheckingAccount> findByCustomerId(Integer customerId);

}