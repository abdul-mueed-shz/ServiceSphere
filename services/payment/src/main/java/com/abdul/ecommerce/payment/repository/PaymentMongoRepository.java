package com.abdul.ecommerce.payment.repository;

import com.abdul.ecommerce.payment.document.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMongoRepository extends MongoRepository<Payment, String> {

}
