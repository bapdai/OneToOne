package com.example.onetoone.repository;

import com.example.onetoone.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepositpory extends JpaRepository<Address, Integer> {
}
