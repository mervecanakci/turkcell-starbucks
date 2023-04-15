package com.kodlama.io.starbucks.repository;

import com.kodlama.io.starbucks.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>  {
    boolean existsByNationalIdentity(String nationalIdentity);

}
