package kk.springframework.springmvc.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kk.springframework.springmvc.domain.Customer;
import kk.springframework.springmvc.domain.Customer.Address;
import lombok.NonNull;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<Integer, Customer> customers;

    public CustomerServiceImpl() {
        loadCustomers();
    }

    @Override
    public List<Customer> listCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        return customers.get(customerId);
    }

    @Override
    public Customer createOrUpdate(@NonNull final Customer customer) {

        if (customer.getCustomerId() == null) {
            customer.setCustomerId(getNextKey());
        }
        customers.put(customer.getCustomerId(), customer);

        return customer;
    }

    @Override
    public void delete(Integer customerId) {
        customers.remove(customerId);
    }

    private Integer getNextKey() {
        return Collections.max(customers.keySet()) + 1;
    }

    private void loadCustomers() {
        customers = new HashMap<>();

        Customer customer =
                new Customer(1, "John", "Grisham", new Address("123 cedar st NE", "apt 221", "Seattle", "WA", 98109));
        customers.put(customer.getCustomerId(), customer);
        customer = new Customer(2, "George", "Campbell",
                                new Address("123 cedar st NE", "apt 221", "Seattle", "WA", 98109));
        customers.put(customer.getCustomerId(), customer);
        customer = new Customer(3, "Bob", "Dylan", new Address("123 cedar st NE", "apt 221", "Seattle", "WA", 98109));
        customers.put(customer.getCustomerId(), customer);
        customer = new Customer(4, "Tom", "Tayloe", new Address("123 cedar st NE", "apt 221", "Seattle", "WA", 98109));
        customers.put(customer.getCustomerId(), customer);
        customer = new Customer(5, "Mark", "W", new Address("123 cedar st NE", "apt 221", "Seattle", "WA", 98109));
        customers.put(customer.getCustomerId(), customer);
        customer = new Customer(6, "Jim", "Beam", new Address("123 cedar st NE", "apt 221", "Seattle", "WA", 98109));
        customers.put(customer.getCustomerId(), customer);
    }
}
