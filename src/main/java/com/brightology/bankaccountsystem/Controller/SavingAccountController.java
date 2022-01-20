package com.brightology.bankaccountsystem.Controller;

import com.brightology.bankaccountsystem.Model.SavingAccount;
import com.brightology.bankaccountsystem.Service.SavingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Validated
public class SavingAccountController {

    @Autowired
    private SavingAccountService savingAccountService;

    @GetMapping("/accesssaving")
    public String withdrawal(Model model) {
        SavingAccount savingAccount = new SavingAccount();
        model.addAttribute("savingAccount", savingAccount);
        return "find_saving_account";
    }
    @GetMapping("/findsavingaccount")
    public String getAccount(@RequestParam(value = "savingId") Integer savingId, Model model) {
        SavingAccount savingAccount = savingAccountService.getAccount(savingId);
        model.addAttribute("savingAccount", savingAccount);
        return "found_saving_account";
    }
    @GetMapping("/savingwithdrawalbutton")
    public String withdrawalbutton(Model model) {
        SavingAccount savingAccount = new SavingAccount();
        model.addAttribute("savingAccount",savingAccount);
        return "withdrawal_savingaccount";
    }
    @PostMapping("/savingwithdrawal")
    public String withdrawal(@RequestParam("savingId") Integer checkingId, @RequestParam("addOrMinusBalance") Integer addOrMinusBalance, Model model) {
        SavingAccount savingAccount = savingAccountService.withdrawal(checkingId, addOrMinusBalance);
        model.addAttribute("savingAccount", savingAccount);
        return "found_saving_account";
    }
    @GetMapping("/savingdepositbutton")
    public String dipositbutton(Model model) {
        SavingAccount savingAccount= new SavingAccount();
        model.addAttribute("savingAccount", savingAccount);
        return "deposit_savingaccount";
    }
    @PostMapping(value = "/savingdeposit")
    public String deposit(@RequestParam("savingId") Integer checkingId, @RequestParam("addOrMinusBalance") Integer addOrMinusBalance, Model model) {
        SavingAccount savingAccount= savingAccountService.deposit(checkingId, addOrMinusBalance);
        model.addAttribute("savingAccount", savingAccount);
        return "found_saving_account";
    }
    @GetMapping("/closesavingaccountbutton")
    public String closeSavingAccount(Model model) {
        SavingAccount savingAccount = new SavingAccount();
        model.addAttribute("savingAccount", savingAccount);
        return "find_saving_account_to_close";
    }
    @GetMapping("/findsavingaccounttoclose")
    public String closeSavingInput(@RequestParam("accountId") Integer savingId, Model model) {
        SavingAccount savingAccount = savingAccountService.closeAccount(savingId);
        model.addAttribute("savingAccount", savingAccount);
        return "closeAccount";
    }
}

