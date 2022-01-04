package com.pgiles.slacker.utils;

import com.pgiles.slacker.api.slack.Attachment;
import com.pgiles.slacker.api.slack.Field;
import com.pgiles.slacker.api.slack.SlackMessage;
import com.pgiles.slacker.domain.Item;
import com.pgiles.slacker.domain.Notification;
import com.pgiles.slacker.domain.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotificationUtils {

    public static Notification orderToSlackMessageNotification(Order order) {
        SlackMessage slackMessage = new SlackMessage();
        List<Item> items = order.getItems();
        if (items == null) {
            slackMessage.setText("Item " + order.getId() + " *Opened*");
        } else {
            Item item = items.get(0);
            String gain_loss = item.getPrice().doubleValue() > 0 ? "up" : "down";
            slackMessage.setText("Item " + order.getId() + " *Closed*" +
                    item.getId() + " for a $" +
                    Math.abs(item.getPrice().doubleValue()) + " " + gain_loss + "."
            );
        }

        slackMessage.setAttachments(addAttachments(order));

        return new Notification(slackMessage);
    }

    private static List<Attachment> addAttachments(Order order) {
        Attachment attachment = new Attachment();
        List<Field> fields = new ArrayList<>();
        String color = "";
        String detail = "<missing>";
        double units = 0;

        if (order.getTotal() != null) {
            units = order.getTotal().doubleValue();
            detail = units > 0 ? "`More`" : "`Less`";
            color = units > 0 ? "#33aa00" : "#f53636";
        }

        fields.add(new Field()
                .withTitle("Order")
                .withValue(order.getTotal().toPlainString())
                .withShort(false)
        );

        if (order.getTotal() != null) {
            fields.add(new Field()
                    .withTitle("Balance")
                    .withValue(order.getTotal().toPlainString())
                    .withShort(true)
            );
        }

        attachment.setColor(color);
        attachment.setText(detail + " " + Math.abs(units) + " @ " + order.getItems().get(0).getPrice().doubleValue());
        attachment.setFields(fields);
        attachment.setFooter("id:" + order.getId() + "\n" + order.getTime());
        attachment.setMrkDwnIn(Collections.singletonList("text"));

        return Collections.singletonList(attachment);
    }

}
