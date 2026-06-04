package com.smartsolutions.eschool.global.notification;

public interface NotificationService {
    void sendNotification(String recipient, String subject, String message);
}
