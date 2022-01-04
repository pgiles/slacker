package com.pgiles.slacker.service;

import com.pgiles.slacker.domain.Notification;

import java.util.List;
import java.util.Map;

/**
 * Quick and dirty.  Not really thinking of all the possible pub/sub implications.
 */
public interface NotificationProducer {

    void send(Notification notification, List<NotificationService.Channel> channel);

    void send(Notification notification, NotificationService.Channel channel);

    void send(String notification, List<NotificationService.Channel> channel);

    void send(String notification, NotificationService.Channel channel);

    void send(Map<NotificationService.Channel, Notification> channelNotificationMap);

}
