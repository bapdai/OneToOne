package com.example.onetoone.restapi;

import com.example.onetoone.entity.Customer;
import com.example.onetoone.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/onetoone/customer")
public class CustomerApi {
    // CURD
    @Autowired
    CustomerService customerService;
    //
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getList(){
        return ResponseEntity.ok(customerService.findAll());
    }
//
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
        public ResponseEntity<?> getDetail(@PathVariable Integer id) {
        Optional<Customer> optionalCustomer = customerService.findById(id);
        if (!optionalCustomer.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalCustomer.get());
    }
//
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Customer> create(@RequestBody Customer address) {
        return ResponseEntity.ok(customerService.save(address));
}

    //    Sua thong tin(U)
    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Customer> update(@PathVariable Integer id, @RequestBody Customer customer) {
        Optional<Customer> optionalCustomer = customerService.findById(id);
        if (!optionalCustomer.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Customer exitsCustomer = optionalCustomer.get();
        //     map object
        exitsCustomer.setName(customer.getName());
        exitsCustomer.setAddress(customer.getAddress());
        return ResponseEntity.ok(customerService.save(exitsCustomer));
    }
    //        Xoa thong tin
    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (!customerService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        customerService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
