package com.kodlama.io.starbucks.adapters;

import com.kodlama.io.starbucks.business.abstracts.CustomerCheckService;
import com.kodlama.io.starbucks.entities.Customer;
import com.kodlama.io.starbucks.mernis.QSDKPSPublicSoap;

public class MernisServiceAdapter implements CustomerCheckService {

    @Override
    public boolean checkIfRealPerson(Customer customer) throws Exception {
        QSDKPSPublicSoap client = new QSDKPSPublicSoap();
        return client.TCKimlikNoDogrula(Long.parseLong(customer.getNationalIdentity()),customer.getFirstName(),customer.getLastName(),customer.getDateOfBirth().getYear());

    }
}