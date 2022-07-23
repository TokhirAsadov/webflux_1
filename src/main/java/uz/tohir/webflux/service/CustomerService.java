package uz.tohir.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import uz.tohir.webflux.dao.CustomerDao;
import uz.tohir.webflux.dto.Customer;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao dao;

    public List<Customer> loadAllCustomer(){
        long start = System.currentTimeMillis();
        List<Customer> customers = dao.getCustomer();
        long end = System.currentTimeMillis();
        System.out.println("Total execution time : "+ (end - start));
        return customers;
    }

    public Flux<Customer> loadAllCustomersStream(){
        long start = System.currentTimeMillis();
        Flux<Customer> customers = dao.getCustomersStream();
        long end = System.currentTimeMillis();
        System.out.println("Total execution time : "+ (end - start));
        return customers;
    }
}
