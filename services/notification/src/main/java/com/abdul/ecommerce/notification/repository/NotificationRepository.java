package com.abdul.ecommerce.notification.repository;

import com.abdul.ecommerce.notification.document.Notification;

public interface NotificationRepository {

    void save(Notification notification);
}
