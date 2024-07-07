package com.abdul.ecommerce.customer.repository;

import com.abdul.ecommerce.customer.document.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMongoRepository extends MongoRepository<Customer, String> {
    
}
