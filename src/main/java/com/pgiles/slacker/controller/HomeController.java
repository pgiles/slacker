package com.pgiles.slacker.controller;

import com.pgiles.slacker.domain.Notification;
import com.pgiles.slacker.domain.Order;
import com.pgiles.slacker.service.HttpsClient;
import com.pgiles.slacker.service.NotificationService;
import com.pgiles.slacker.utils.NotificationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@ComponentScan
public class HomeController {

    final static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Value("${executors.threadPoolSize:50}")
    int anInt;

    @Value("${executors.threadPoolName:swim team}")
    String aString;

    @Autowired
    private NotificationService notifier;

    @Autowired
    private HttpsClient httpsClient;
    
    /**
     * This is just a sanity check that property injection is working as expected
     * @return a string
     */
    @RequestMapping("/home/props")
    public String propCheck() {
        logger.info("poolsize string is {}", aString);
        return anInt + " " + aString;
    }

    @RequestMapping("/secure")
    public String call(@RequestParam String url) {
        if (!url.startsWith("https://")) {
            return "I only work with the https scheme.";
        }
        logger.info("calling " + url);
        String result;
        try {
            result = httpsClient.get(url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @GetMapping("/")
    public Notification index() {
        return slackMe(Order.stub());
    }

    private Notification slackMe (Order order) {
        Notification n = NotificationUtils.orderToSlackMessageNotification(order);
        notifier.send(Collections.singletonMap(NotificationService.Channel.SLACK, n));
        return n;
    }

}
