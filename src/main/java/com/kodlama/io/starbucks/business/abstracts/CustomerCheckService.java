package com.kodlama.io.starbucks.business.abstracts;

import com.kodlama.io.starbucks.entities.Customer;

public interface CustomerCheckService {
    boolean checkIfRealPerson(Customer customer) throws Exception;

}
