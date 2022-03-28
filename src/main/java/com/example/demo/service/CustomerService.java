package com.example.demo.service;

import com.example.demo.dao.CustomerRepositoryDAO;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepositoryDAO customerRepositoryDAO;

    public Customer addCustomer(Customer customer) {
        return customerRepositoryDAO.save(customer);
    }

    public List<Customer> getCustomerList() {
        return customerRepositoryDAO.findAll();
    }

    public Customer getCustomer(int customerId) {
        Optional<Customer> optionalCustomer = customerRepositoryDAO.findById(customerId);
        if(!optionalCustomer.isPresent()) {
            throw new CustomerNotFoundException("Customer Record Not Available");
        }
        return optionalCustomer.get();
    }

    public Customer updateCustomer(int id, Customer customer) {
        customer.setCustomerId(id);
        return customerRepositoryDAO.save(customer);
    }

    public void deleteCustomer(int customerId) {
        customerRepositoryDAO.deleteById(customerId);
    }
//    private int customerIdCount = 1;
//    private List<Customer> customerList = new CopyOnWriteArrayList<>();
//
//    public Customer addCustomer(Customer customer) {
//        customer.setCustomerId(customerIdCount);
//        customerList.add(customer);
//        customerIdCount++;
//        return customer;
//    }
//
//    public List<Customer> getCustomerList() {
//        return customerList;
//    }
//
//    public Customer getCustomer(int customerId) {
//        return customerList.stream().filter(c-> c.getCustomerId() == customerId).findFirst().get();
//    }
//
//    public Customer updateCustomre(int customerId, Customer customer) {
//        customerList.stream().forEach(c-> {
//                    if(c.getCustomerId() == customerId) {
//                        c.setCustomerFirstName(customer.getCustomerFirstName());
//                        c.setCustomerLastName(customer.getCustomerLastName());
//                    }
//                });
//        return customerList.stream().filter(c -> c.getCustomerId() == customerId).findFirst().get();
//    }
//
//    public void deleteCustomer(int customerId) {
//         customerList.stream().forEach(c-> {
//            if(c.getCustomerId() == customerId) {
//                customerList.remove(c);
//            }
//        });
//    }
}
