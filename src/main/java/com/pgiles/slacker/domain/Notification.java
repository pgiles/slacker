package com.pgiles.slacker.domain;

import com.pgiles.slacker.api.slack.SlackMessage;

/**
 * Quick and dirty.  For now we only need a message to send, no meta-data.  When we need to add an envelope
 * or message metadata we have this to use.
 *
 */
public class Notification {

    private String message;
    private SlackMessage slackMessage;

    public Notification(String message) {
        this.message = message;
    }

    public Notification(SlackMessage slackMessage) {
        this.slackMessage = slackMessage;
    }

    public String getMessage() {
        return message;
    }

    public SlackMessage getSlackMessage() {
        return slackMessage;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "message='" + message + '\'' +
                ", slackMessage=" + slackMessage +
                '}';
    }
}
