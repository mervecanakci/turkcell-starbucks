package com.kodlama.io.starbucks.configuration.adapter;

import com.kodlama.io.starbucks.adapters.MernisServiceAdapter;
import com.kodlama.io.starbucks.business.abstracts.CustomerCheckService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerCheckConfig {
    @Bean
    public CustomerCheckService getCustomerCheckService(){
        return new MernisServiceAdapter();
    }
}