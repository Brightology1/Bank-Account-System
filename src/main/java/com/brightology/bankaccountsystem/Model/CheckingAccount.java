package com.brightology.bankaccountsystem.Model;

import javax.persistence.*;

@Entity
@Table(name="checking_account")
public class CheckingAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "checking_id")
    private Integer checkingId;
    @Column(name = "balance")
    private Integer balance;
    @Column(name = "add_subtract_balance")
    private Integer addOrMinusBalance;
    @Column(name = "new_balance")
    private Integer newBalance;
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "status")
    private String status;

    public CheckingAccount() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCheckingId() {
        return checkingId;
    }

    public void setCheckingId(Integer checkingId) {
        this.checkingId = checkingId;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getAddOrMinusBalance() {
        return addOrMinusBalance;
    }

    public void setAddOrMinusBalance(Integer addOrMinusBalance) {
        this.addOrMinusBalance = addOrMinusBalance;
    }

    public Integer getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(Integer newBalance) {
        this.newBalance = newBalance;
    }

}
