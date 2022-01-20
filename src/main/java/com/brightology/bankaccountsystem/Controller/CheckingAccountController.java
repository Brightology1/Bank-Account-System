package com.brightology.bankaccountsystem.Controller;

import com.brightology.bankaccountsystem.Model.CheckingAccount;
import com.brightology.bankaccountsystem.Service.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.Min;

@Controller
@Validated
public class CheckingAccountController {

    @Autowired
    private CheckingService checkingService;

    @GetMapping("/accesschecking")
    public String withdrawal(Model model) {
        CheckingAccount checkingAccount = new CheckingAccount();
        model.addAttribute("checkingAccount", checkingAccount);
        return "find_checking_account";
    }

    @GetMapping("/findcheckingaccount")
    public String getAccount(@RequestParam(value = "checkingId") Integer checkingId, Model model) {
        CheckingAccount checkingAccount = checkingService.getAccount(checkingId);
        model.addAttribute("checkingAccount", checkingAccount);
        return "Found_checking_account";
    }

    @GetMapping("/checkingwithdrawalbutton")
    public String withdrawalbutton(Model model) {
        CheckingAccount checkingAccount = new CheckingAccount();
        model.addAttribute("checkingAccount", checkingAccount);
        return "withdrawal_checkingaccount";
    }

    @PostMapping("/checkingwithdrawal")
    public String withdrawal(@RequestParam("checkingId") Integer checkingId, @RequestParam("addOrMinusBalance") Integer addOrMinusBalance, Model model) {
        CheckingAccount checkingAccount = checkingService.withdrawal(checkingId, addOrMinusBalance);
        model.addAttribute("checkingAccount", checkingAccount);
        return "Found_checking_account";
    }

    @GetMapping("/checkingdepositbutton")
    public String depositbutton(Model model) {
        CheckingAccount checkingAccount = new CheckingAccount();
        model.addAttribute("checkingAccount", checkingAccount);
        return "deposit_checkingaccount";
    }
    @PostMapping(value = "/checkingdeposit")
    public String deposit(@RequestParam("checkingId") Integer checkingId, @RequestParam("addOrMinusBalance") @Min(2) Integer addOrMinusBalance, Model model) {
        CheckingAccount checkingAccount = checkingService.deposit(checkingId, addOrMinusBalance);
        model.addAttribute("checkingAccount", checkingAccount);
        return "Found_checking_account";
    }
    @GetMapping("/closecheckingaccountbutton")
    public String closeCheckingAccount(Model model) {
        CheckingAccount checkingAccount = new CheckingAccount();
        model.addAttribute("checkingAccount", checkingAccount);
        return "find_checking_account_to_close";
    }
    @GetMapping("/findcheckingaccounttoclose")
    public String closeAccountInput(@RequestParam("accountId") Integer checkingId, Model model) {
        CheckingAccount checkingAccount = checkingService.closeAccount(checkingId);
        model.addAttribute("checkingAccount", checkingAccount);
        return "closeAccount";
    }
}
