package com.ead.notification.services.impl;

import com.ead.notification.services.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    final NotificationService notificationService;

    public NotificationServiceImpl(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
}
