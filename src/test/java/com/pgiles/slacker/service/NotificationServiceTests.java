package com.pgiles.slacker.service;

import com.pgiles.slacker.domain.Notification;
import com.pgiles.slacker.domain.Order;
import com.pgiles.slacker.domain.OrderStub;
import com.pgiles.slacker.utils.NotificationUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@SpringBootTest
@ActiveProfiles("test")
public class NotificationServiceTests {

    @Autowired
    NotificationService service;

    @Test
    public void testSendOneToSlack() {
        service.send("test message string", NotificationService.Channel.SLACK);
    }

    @Test
    public void testSendOneToMany() {
        List<NotificationService.Channel> channels = Arrays.asList(NotificationService.Channel.values());
        service.send("test message strings", channels);
    }

    @Test
    public void testSendNotificationToSlack() {
        service.send(new Notification("test notification"), NotificationService.Channel.SLACK);
    }

    @Test
    public void testSendOneNotificationToMany() {
        List<NotificationService.Channel> channels = Arrays.asList(NotificationService.Channel.values());
        service.send(new Notification("test notifications"), channels);
    }

    @Test
    public void testSendNotificationMapMinimumNumberOfFields() {
        Order order = OrderStub.minimumNumberOfFields();

        Map<NotificationService.Channel, Notification> notificationMap;
        notificationMap = Collections.singletonMap(NotificationService.Channel.SLACK,
                NotificationUtils.orderToSlackMessageNotification(order));
        service.send(notificationMap);
    }

    @Test
    public void testSendNotificationMapOpening() {
        Order order = OrderStub.opening();

        Map<NotificationService.Channel, Notification> notificationMap;
        notificationMap = Collections.singletonMap(NotificationService.Channel.SLACK,
                NotificationUtils.orderToSlackMessageNotification(order));
        service.send(notificationMap);
    }

    @Test
    public void testSendNotificationMapClosing() {
        Order order = OrderStub.closing();

        Map<NotificationService.Channel, Notification> notificationMap;
        notificationMap = Collections.singletonMap(NotificationService.Channel.SLACK,
                NotificationUtils.orderToSlackMessageNotification(order));
        service.send(notificationMap);
    }
}
