package kk.springframework.springmvc.controllers;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kk.springframework.springmvc.domain.Customer;
import kk.springframework.springmvc.services.CustomerService;

@RequestMapping("/customer")
@Controller
public class CustomerController {

    Logger log = Logger.getGlobal();

    @Autowired
    private CustomerService customerService;

    @RequestMapping({"/list", "/"})
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerService.listAll());
        return "customers";
    }

    @RequestMapping("/{customerId}")
    public String getCustomerById(@PathVariable Integer customerId, Model model) {
        model.addAttribute("customer", customerService.getById(customerId));
        return "customer";
    }

    @RequestMapping("/new")
    public String newCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customerform";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createOrUpdateCustomer(Customer customer, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "customers";
        }
        System.out.println("customer received" + customer);
        log.info(" cust received" + customer);
        Customer savedOrUpdateCustomer = customerService.createOrUpdate(customer);
        System.out.println(savedOrUpdateCustomer);
        return "redirect:/customer/" + savedOrUpdateCustomer.getId();
    }

    @RequestMapping("/edit/{customerId}")
    public String editCustomer(@PathVariable Integer customerId, Model model) {
        model.addAttribute("customer", customerService.getById(customerId));
        return "customerform";
    }

    @RequestMapping("/delete/{customerId}")
    public String deleteCustomer(@PathVariable Integer customerId) {
        customerService.delete(customerId);
        return "redirect:/customers";
    }
}
