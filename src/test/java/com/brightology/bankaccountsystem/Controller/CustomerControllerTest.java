package com.brightology.bankaccountsystem.Controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.brightology.bankaccountsystem.Model.Customer;
import com.brightology.bankaccountsystem.Service.CustomerService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CustomerController.class})
@ExtendWith(SpringExtension.class)
class CustomerControllerTest {
    @Autowired
    private CustomerController customerController;

    @MockBean
    private CustomerService customerService;

    @Test
    void testAccountAccess() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/accessform");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("access_account"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("access_account"));
    }

    @Test
    void testAccountAccess2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/accessform", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("access_account"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("access_account"));
    }

    @Test
    void testAccountAccess3() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/accessform");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("access_account"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("access_account"));
    }

    @Test
    void testAccountAccess4() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/accessform", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("access_account"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("access_account"));
    }

    @Test
    void testCreateCheckingAccount() throws Exception {
        Customer customer = new Customer();
        customer.setCheckingAccount(new ArrayList<>());
        customer.setCustomerId(123);
        customer.setFirstCheckingAmount(1);
        customer.setFirstName("Jane");
        customer.setFirstSavingAmount(1);
        customer.setLastName("Doe");
        customer.setSavingAccount(new ArrayList<>());
        customer.setStatus("Status");
        when(this.customerService.newCheckingAccount((String) any(), (String) any(), (Integer) any())).thenReturn(customer);
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/createcheckingaccount");
        MockHttpServletRequestBuilder requestBuilder = postResult.param("firstCheckingAmount", String.valueOf(1))
                .param("firstName", "foo")
                .param("lastName", "foo");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("success"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("success"));
    }

    @Test
    void testCreateCheckingAccount2() throws Exception {
        Customer customer = new Customer();
        customer.setCheckingAccount(new ArrayList<>());
        customer.setCustomerId(123);
        customer.setFirstCheckingAmount(1);
        customer.setFirstName("Jane");
        customer.setFirstSavingAmount(1);
        customer.setLastName("Doe");
        customer.setSavingAccount(new ArrayList<>());
        customer.setStatus("Status");
        when(this.customerService.newCheckingAccount((String) any(), (String) any(), (Integer) any())).thenReturn(customer);
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/createcheckingaccount");
        MockHttpServletRequestBuilder requestBuilder = postResult.param("firstCheckingAmount", String.valueOf(1))
                .param("firstName", "foo")
                .param("lastName", "foo");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("success"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("success"));
    }

    @Test
    void testCreateSavingAccount() throws Exception {
        Customer customer = new Customer();
        customer.setCheckingAccount(new ArrayList<>());
        customer.setCustomerId(123);
        customer.setFirstCheckingAmount(1);
        customer.setFirstName("Jane");
        customer.setFirstSavingAmount(1);
        customer.setLastName("Doe");
        customer.setSavingAccount(new ArrayList<>());
        customer.setStatus("Status");
        when(this.customerService.newCheckingNSavingAccount((String) any(), (String) any(), (Integer) any(),
                (Integer) any())).thenReturn(customer);
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/createcheckingNsaving");
        MockHttpServletRequestBuilder paramResult = postResult.param("firstCheckingAmount", String.valueOf(1))
                .param("firstName", "foo");
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("firstSavingAmount", String.valueOf(1))
                .param("lastName", "foo");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("success"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("success"));
    }

    @Test
    void testCreateSavingAccount2() throws Exception {
        Customer customer = new Customer();
        customer.setCheckingAccount(new ArrayList<>());
        customer.setCustomerId(123);
        customer.setFirstCheckingAmount(1);
        customer.setFirstName("Jane");
        customer.setFirstSavingAmount(1);
        customer.setLastName("Doe");
        customer.setSavingAccount(new ArrayList<>());
        customer.setStatus("Status");
        when(this.customerService.newSavingAccount((String) any(), (String) any(), (Integer) any())).thenReturn(customer);
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/createsavingaccount");
        MockHttpServletRequestBuilder requestBuilder = postResult.param("firstCheckingAmount", String.valueOf(1))
                .param("firstName", "foo")
                .param("lastName", "foo");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("success"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("success"));
    }

    @Test
    void testCreateSavingAccount3() throws Exception {
        Customer customer = new Customer();
        customer.setCheckingAccount(new ArrayList<>());
        customer.setCustomerId(123);
        customer.setFirstCheckingAmount(1);
        customer.setFirstName("Jane");
        customer.setFirstSavingAmount(1);
        customer.setLastName("Doe");
        customer.setSavingAccount(new ArrayList<>());
        customer.setStatus("Status");
        when(this.customerService.newCheckingNSavingAccount((String) any(), (String) any(), (Integer) any(),
                (Integer) any())).thenReturn(customer);
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/createcheckingNsaving");
        MockHttpServletRequestBuilder paramResult = postResult.param("firstCheckingAmount", String.valueOf(1))
                .param("firstName", "foo");
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("firstSavingAmount", String.valueOf(1))
                .param("lastName", "foo");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("success"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("success"));
    }

    @Test
    void testCreateSavingAccount4() throws Exception {
        Customer customer = new Customer();
        customer.setCheckingAccount(new ArrayList<>());
        customer.setCustomerId(123);
        customer.setFirstCheckingAmount(1);
        customer.setFirstName("Jane");
        customer.setFirstSavingAmount(1);
        customer.setLastName("Doe");
        customer.setSavingAccount(new ArrayList<>());
        customer.setStatus("Status");
        when(this.customerService.newSavingAccount((String) any(), (String) any(), (Integer) any())).thenReturn(customer);
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/createsavingaccount");
        MockHttpServletRequestBuilder requestBuilder = postResult.param("firstCheckingAmount", String.valueOf(1))
                .param("firstName", "foo")
                .param("lastName", "foo");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("success"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("success"));
    }

    @Test
    void testNewCheckingAccount() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/newcheckingaccount");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("new_checking_account"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("new_checking_account"));
    }

    @Test
    void testNewCheckingAccount2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/newcheckingaccount");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("new_checking_account"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("new_checking_account"));
    }

    @Test
    void testNewCheckingAccount3() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/newcheckingaccount");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("new_checking_account"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("new_checking_account"));
    }

    @Test
    void testNewCheckingAccount4() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/newcheckingaccount");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("new_checking_account"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("new_checking_account"));
    }

    @Test
    void testNewCustomerForm() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/showNewCustomerForm");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("new_customer"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("new_customer"));
    }

    @Test
    void testNewCustomerForm2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/showNewCustomerForm");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("new_customer"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("new_customer"));
    }

    @Test
    void testNewCustomerForm3() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/showNewCustomerForm");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("new_customer"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("new_customer"));
    }

    @Test
    void testNewCustomerForm4() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/showNewCustomerForm");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("new_customer"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("new_customer"));
    }

    @Test
    void testNewSavingAccount() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/newsavingaccount");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("new_saving_account"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("new_saving_account"));
    }

    @Test
    void testNewSavingAccount2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/newsavingaccount");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("new_saving_account"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("new_saving_account"));
    }

    @Test
    void testNewSavingAccount3() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/newsavingaccount");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("new_saving_account"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("new_saving_account"));
    }

    @Test
    void testNewSavingAccount4() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/newsavingaccount");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("new_saving_account"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("new_saving_account"));
    }

    @Test
    void testNewSavingNCheckingAccount() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/newcheckingandsaving");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("new_checking_N_saving"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("new_checking_N_saving"));
    }

    @Test
    void testNewSavingNCheckingAccount2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/newcheckingandsaving");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("new_checking_N_saving"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("new_checking_N_saving"));
    }

    @Test
    void testNewSavingNCheckingAccount3() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/newcheckingandsaving");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("new_checking_N_saving"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("new_checking_N_saving"));
    }

    @Test
    void testNewSavingNCheckingAccount4() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/newcheckingandsaving");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("new_checking_N_saving"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("new_checking_N_saving"));
    }

    @Test
    void testViewHomePage() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("index"));
    }

    @Test
    void testViewHomePage2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("index"));
    }

    @Test
    void testViewHomePage3() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("index"));
    }

    @Test
    void testViewHomePage4() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.customerController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("index"));
    }
}

