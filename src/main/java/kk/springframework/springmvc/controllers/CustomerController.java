package kk.springframework.springmvc.controllers;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kk.springframework.springmvc.domain.Customer;
import kk.springframework.springmvc.services.CustomerService;
import lombok.extern.log4j.Log4j2;

@Controller
public class CustomerController {

    Logger log = Logger.getGlobal();

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerService.listCustomers());
        return "customers";
    }

    @RequestMapping("/customer/{customerId}")
    public String getCustomerById(@PathVariable Integer customerId, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(customerId));
        return "customer";
    }

    @RequestMapping("/customer/new")
    public String newCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customerform";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String createOrUpdateCustomer(Customer customer, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "customers";
        }
        System.out.println("customer received" + customer);
        log.info(" cust received" + customer);
        Customer savedOrUpdateCustomer = customerService.createOrUpdate(customer);
        System.out.println(savedOrUpdateCustomer);
        return "redirect:/customer/" + savedOrUpdateCustomer.getCustomerId();
    }

    @RequestMapping("/customer/edit/{customerId}")
    public String editCustomer(@PathVariable Integer customerId, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(customerId));
        return "customerform";
    }

    @RequestMapping("/customer/delete/{customerId}")
    public String deleteCustomer(@PathVariable Integer customerId) {
        customerService.delete(customerId);
        return "redirect:/customers";
    }
}
