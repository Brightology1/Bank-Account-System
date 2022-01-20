package com.brightology.bankaccountsystem.Model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="customer_id")
    private Integer customerId;
    @Column(name="first_name")
    @Size(min = 2)
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="status")
    private String status;
    @Column(name ="first_checking_amount")
    private Integer firstCheckingAmount;
    @Column(name ="firstime_saving_amount")
    private Integer firstSavingAmount;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id", referencedColumnName = "customer_id")
    private List<SavingAccount> savingAccount;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id", referencedColumnName = "customer_id")
    private List<CheckingAccount>checkingAccount;

    public Customer() {
    }

    public Integer getFirstCheckingAmount() {
        return firstCheckingAmount;
    }

    public void setFirstCheckingAmount(Integer firstCheckingAmount) {
        this.firstCheckingAmount = firstCheckingAmount;
    }

    public Integer getFirstSavingAmount() {
        return firstSavingAmount;
    }

    public void setFirstSavingAmount(Integer firstSavingAmount) {
        this.firstSavingAmount = firstSavingAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CheckingAccount> getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(List<CheckingAccount> checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public List<SavingAccount> getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(List<SavingAccount> savingAccount) {
        this.savingAccount = savingAccount;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}

