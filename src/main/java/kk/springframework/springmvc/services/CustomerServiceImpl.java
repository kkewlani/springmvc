package kk.springframework.springmvc.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import kk.springframework.springmvc.domain.Customer;
import kk.springframework.springmvc.domain.Customer.Address;
import kk.springframework.springmvc.domain.DomainObject;
import lombok.NonNull;

@Service
public class CustomerServiceImpl extends AbstractDomainMapService implements CustomerService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public void delete(Integer customerId) {
        super.delete(customerId);
    }

    @Override
    public Customer createOrUpdate(@NonNull Customer customer) {
        return (Customer) super.createOrUpdate(customer);
    }

    @Override
    public Customer getById(Integer productId) {
        return (Customer) super.getById(productId);
    }

    @Override
    protected void loadDomainObjectsMap() {
        domainObjectsMap = new HashMap<>();

        Customer customer = new Customer("John", "Grisham", "123 cedar st NE", "apt 221", "Seattle", "WA", 98109);
        domainObjectsMap.put(customer.getId(), customer);
        customer = new Customer("George", "Campbell", "123 cedar st NE", "apt 221", "Seattle", "WA", 98109);
        domainObjectsMap.put(customer.getId(), customer);
        customer = new Customer("Bob", "Dylan", "123 cedar st NE", "apt 221", "Seattle", "WA", 98109);
        domainObjectsMap.put(customer.getId(), customer);
        customer = new Customer("Tom", "Tayloe", "123 cedar st NE", "apt 221", "Seattle", "WA", 98109);
        domainObjectsMap.put(customer.getId(), customer);
        customer = new Customer("Mark", "W", "123 cedar st NE", "apt 221", "Seattle", "WA", 98109);
        domainObjectsMap.put(customer.getId(), customer);
        customer = new Customer("Jim", "Beam", "123 cedar st NE", "apt 221", "Seattle", "WA", 98109);
        domainObjectsMap.put(customer.getId(), customer);
    }
}
