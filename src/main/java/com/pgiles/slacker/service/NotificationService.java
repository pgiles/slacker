package com.pgiles.slacker.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pgiles.slacker.domain.Notification;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class NotificationService implements NotificationProducer {

    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);
    private ObjectMapper mapper = new ObjectMapper();

    public enum Channel {
        SLACK,
        //TODO SNS
    }

    @Value("${slack.host}")
    private String slack_host;
    @Value("${slack.webhook}")
    private String slack_webhook;

    @Override
    public void send(Notification notification, Channel channel) {
        send(notification.getMessage(), Collections.singletonList(channel));
    }

    @Override
    public void send(Notification notification, List<Channel> channels) {
        channels.forEach(channel ->
                send(notification.getMessage(), channel)
        );
    }

    @Override
    public void send(String notification, Channel channel) {
        send(notification, Collections.singletonList(channel));
    }

    @Override
    public void send(String notification, List<Channel> channels) {
        for (Channel channel : channels) {
            if (channel == Channel.SLACK) {
                postToSlack("{\"text\":\"" + notification + "\"}");
            }
        }
    }

    @Override
    public void send(Map<Channel, Notification> channelNotificationMap) {
        for (Map.Entry<Channel, Notification> entry : channelNotificationMap.entrySet()) {
            if (entry.getKey() == Channel.SLACK) {
                try {
                    postToSlack(mapper.writeValueAsString(entry.getValue().getSlackMessage()));
                } catch (JsonProcessingException e) {
                    log.error("", e);
                    send(entry.getValue(), Channel.SLACK);
                }
            }
        }
    }

    private void postToSlack(String json) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(composeSlackWebhook());
        httpPost.setHeader("Accept", MediaType.APPLICATION_JSON_VALUE);
        httpPost.setHeader("Content-type", MediaType.APPLICATION_JSON_VALUE);

        try {
            StringEntity entity = new StringEntity(json);
            httpPost.setEntity(entity);
            CloseableHttpResponse resp = client.execute(httpPost);
            if (resp.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                log.error("Failed to post to Slack Webhook. {}", resp);
            }
        } catch (IOException e) {
            log.error("Failed to send message to Slack Webhook", e);
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private URI composeSlackWebhook() {
        return UriComponentsBuilder
                .newInstance().scheme("https")
                .host(slack_host)
                .path(slack_webhook)
                .build().toUri();
    }

}
