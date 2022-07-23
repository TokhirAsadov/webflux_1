package uz.tohir.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import uz.tohir.webflux.dto.Customer;
import uz.tohir.webflux.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public List<Customer> getAllCustomer(){
        return service.loadAllCustomer();
    }

    @GetMapping(value = "/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomerStream(){
        return service.loadAllCustomersStream();
    }

        /****
            data:{"id":1,"name":"customer1"}

            data:{"id":2,"name":"customer2"}

            data:{"id":3,"name":"customer3"}

            data:{"id":4,"name":"customer4"}

            data:{"id":5,"name":"customer5"}

            data:{"id":6,"name":"customer6"}

            data:{"id":7,"name":"customer7"}

            data:{"id":8,"name":"customer8"}

            data:{"id":9,"name":"customer9"}

            data:{"id":10,"name":"customer10"}
        ****/
        // WEB FLUX AMALLARNI BAJARIB BROWSER GA JUNATADI
}
