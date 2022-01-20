package com.brightology.bankaccountsystem.Repository;

import com.brightology.bankaccountsystem.Model.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SavingAccountRepo extends JpaRepository<SavingAccount,Integer> {
    public Optional<SavingAccount> findByCustomerId(Integer customerId);

}
