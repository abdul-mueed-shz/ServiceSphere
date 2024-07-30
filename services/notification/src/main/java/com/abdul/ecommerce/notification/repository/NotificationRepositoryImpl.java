package com.abdul.ecommerce.notification.repository;

import com.abdul.ecommerce.notification.document.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class NotificationRepositoryImpl implements NotificationRepository {

    private final NotificationMongoRepository notificationMongoRepository;

    @Override
    public void save(Notification notification) {
        notificationMongoRepository.save(notification);
    }

}
