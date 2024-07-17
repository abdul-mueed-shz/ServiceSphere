package com.abdul.ecommerce.notification.repository;

import com.abdul.ecommerce.notification.document.Notification;
import org.springframework.stereotype.Repository;

@Repository
public class NotificationRepositoryImpl implements NotificationRepository {

    private NotificationMongoRepository notificationMongoRepository;

    @Override
    public void save(Notification notification) {
        notificationMongoRepository.save(notification);
    }

}
