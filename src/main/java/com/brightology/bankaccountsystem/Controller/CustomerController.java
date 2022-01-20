package com.brightology.bankaccountsystem.Controller;

import com.brightology.bankaccountsystem.Model.Customer;
import com.brightology.bankaccountsystem.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@Validated
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return "index";
    }

    @GetMapping("/showNewCustomerForm")
    public String newCustomerForm() {
        return "new_customer";
    }

    @GetMapping("/newcheckingaccount")
    public String newCheckingAccount(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new_checking_account";
    }

    @GetMapping("/newsavingaccount")
    public String newSavingAccount(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new_saving_account";
    }

    @GetMapping("/newcheckingandsaving")
    public String newSavingNCheckingAccount(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new_checking_N_saving";
    }

    @GetMapping("/accessform")
    public String accountAccess(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "access_account";
    }

    @PostMapping("/createcheckingaccount")
    public String createCheckingAccount(String firstName, String lastName, Integer firstCheckingAmount, Model model, SessionStatus status) {
        Customer customer = customerService.newCheckingAccount(firstName, lastName, firstCheckingAmount);
        model.addAttribute("customer", customer);

        status.setComplete();

        return "success";
    }

    @PostMapping("/createsavingaccount")
    public String createSavingAccount(String firstName, String lastName, Integer firstCheckingAmount, Model model, SessionStatus status) {
        Customer customer = customerService.newSavingAccount(firstName, lastName, firstCheckingAmount);
        model.addAttribute("customer", customer);

        status.setComplete();

        return "success";
    }

    @PostMapping("/createcheckingNsaving")
    public String createSavingAccount(String firstName, String lastName, Integer firstCheckingAmount, Integer firstSavingAmount, Model model, SessionStatus status) {
        Customer customer = customerService.newCheckingNSavingAccount(firstName, lastName, firstCheckingAmount, firstSavingAmount);
        model.addAttribute("customer", customer);

        status.setComplete();

        return "success";
    }
}
