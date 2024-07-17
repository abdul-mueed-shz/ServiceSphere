package com.abdul.ecommerce.notification.repository;

import com.abdul.ecommerce.notification.document.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationMongoRepository extends MongoRepository<Notification, String> {

}
