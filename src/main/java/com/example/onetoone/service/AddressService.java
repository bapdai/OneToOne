package com.example.onetoone.service;

import com.example.onetoone.entity.Address;
import com.example.onetoone.repository.AddressRepositpory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepositpory addressRepositpory;

    public List<Address> findAll() {
        return addressRepositpory.findAll();
    }

    public Optional<Address> findById(Integer sonha){
        return addressRepositpory.findById(sonha);
    }

    public Address save(Address address){
        return addressRepositpory.save(address);
    }

    public void deleteById(Integer sonha) {
        addressRepositpory.deleteById(sonha);
    }
}
