package com.kodlama.io.starbucks.business.abstracts;

import com.kodlama.io.starbucks.business.dto.requests.CreateCustomerRequest;
import com.kodlama.io.starbucks.business.dto.responses.create.CreateCustomerResponse;
import com.kodlama.io.starbucks.business.dto.responses.get.GetAllCustomersResponse;

import java.util.List;

public interface CustomerService {
    List<GetAllCustomersResponse> getAll();
    CreateCustomerResponse add(CreateCustomerRequest request) throws Exception;

}
