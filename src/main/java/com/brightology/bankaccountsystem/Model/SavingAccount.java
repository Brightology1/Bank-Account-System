package com.brightology.bankaccountsystem.Model;

import javax.persistence.*;

@Entity
@Table(name="saving_account")
public class SavingAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="saving_id")
    private Integer savingId;
    @Column(name="balance")
    private Integer balance;
    @Column(name="add_subtract_balance")
    private Integer addOrMinusBalance;
    @Column(name="new_balance")
    private Integer newBalance;
    @Column(name="customer_id")
    private Integer customerId;
    @Column(name="status")
    private String status;

    public SavingAccount() {
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public Integer getAddOrMinusBalance() { return addOrMinusBalance; }

    public void setAddOrMinusBalance(Integer addOrMinusBalance) { this.addOrMinusBalance = addOrMinusBalance; }

    public Integer getSavingId() {
        return savingId;
    }

    public void setSavingId(Integer savingId) {
        this.savingId = savingId;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getAddorMinusBalance() {
        return addOrMinusBalance;
    }

    public void setAddorMinusBalance(Integer addorMinusBalance) {
        this.addOrMinusBalance = addorMinusBalance;
    }

    public Integer getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(Integer newBalance) {
        this.newBalance = newBalance;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
