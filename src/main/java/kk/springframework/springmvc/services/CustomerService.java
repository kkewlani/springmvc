package kk.springframework.springmvc.services;

import java.util.List;

import kk.springframework.springmvc.domain.Customer;

public interface CustomerService {

    List<Customer> listCustomers();

    Customer getCustomerById(Integer customerId);

    Customer createOrUpdate(Customer customer);

    void delete(Integer customerId);

}
