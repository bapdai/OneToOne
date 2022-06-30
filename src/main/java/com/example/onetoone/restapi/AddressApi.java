package com.example.onetoone.restapi;

import com.example.onetoone.entity.Address;
import com.example.onetoone.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/onetoone/address")
public class AddressApi {
    @Autowired
    AddressService addressService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Address>> getList() {
        return ResponseEntity.ok(addressService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "{sonha}")
    public ResponseEntity<?> getDetail(@PathVariable Integer sonha) {
        Optional<Address> optionalAddress = addressService.findById(sonha);
        if (!optionalAddress.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalAddress.get());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Address> create(@RequestBody Address address) {
        return ResponseEntity.ok(addressService.save(address));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{sonha}")
    public ResponseEntity<Address> update(@PathVariable Integer sonha, @RequestBody Address address) {
        Optional<Address> optionalAddress = addressService.findById(sonha);
        if (!optionalAddress.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Address existAddress = optionalAddress.get();
        // map object
        existAddress.setSonha(address.getSonha());
        existAddress.setDiachi(address.getDiachi());
        return ResponseEntity.ok(addressService.save(existAddress));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{sonha}")
    public ResponseEntity<?> delete(@PathVariable Integer sonha) {
        if (!addressService.findById(sonha).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        addressService.deleteById(sonha);
        return ResponseEntity.ok().build();
    }

}
