package com.kodlama.io.starbucks.business.concretes;

import com.kodlama.io.starbucks.business.abstracts.CustomerCheckService;
import com.kodlama.io.starbucks.business.abstracts.CustomerService;
import com.kodlama.io.starbucks.business.dto.requests.CreateCustomerRequest;
import com.kodlama.io.starbucks.business.dto.responses.create.CreateCustomerResponse;
import com.kodlama.io.starbucks.business.dto.responses.get.GetAllCustomersResponse;
import com.kodlama.io.starbucks.entities.Customer;
import com.kodlama.io.starbucks.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository repository;
    private final ModelMapper mapper;
    private final CustomerCheckService checkService;

    @Override
    public List<GetAllCustomersResponse> getAll() {
        List<Customer> customers = repository.findAll();
        List<GetAllCustomersResponse> response = customers
                .stream()
                .map(customer -> mapper.map(customer, GetAllCustomersResponse.class))
                .toList();
        return response;

    }

    @Override
    public CreateCustomerResponse add(CreateCustomerRequest request) throws Exception {
        checkIfCustomerExists(request);
        Customer customer = mapper.map(request, Customer.class);
        customer.setId(0);
        checkIfIsCustomerRealPerson(customer);
        repository.save(customer);
        CreateCustomerResponse response = mapper.map(customer, CreateCustomerResponse.class);

        return response;
    }

    private void checkIfCustomerExists(CreateCustomerRequest request) {
        if(repository.existsByNationalIdentity(request.getNationalIdentity())) {
            throw new RuntimeException("Bu müşteri zaten kayıtlı!");
        }
    }

    private void checkIfIsCustomerRealPerson(Customer customer) throws Exception {
        if (!checkService.checkIfRealPerson(customer))   throw new Exception("Kullanıcı doğrulanamadı!");

    }

}
