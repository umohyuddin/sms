package com.smartsolutions.eschool.global.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MockNotificationService implements NotificationService {
    @Override
    public void sendNotification(String recipient, String subject, String message) {
        log.info("[Notification:Mock] Sending to: {} | Subject: {} | Message: {}", recipient, subject, message);
    }
}
