package com.pgiles.slacker.api.slack;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "title_link",
    "text",
    "pretext",
    "fallback",
    "callback_id",
    "color",
    "fields",
    "actions",
    "image_url",
    "thumb_url",
    "footer",
    "footer_icon",
    "mrkdwn_in",
    "ts"
})
public class Attachment implements Serializable
{

    @JsonProperty("title")
    private String title;
    @JsonProperty("title_link")
    private String titleLink;
    @JsonProperty("text")
    private String text;
    @JsonProperty("pretext")
    private String pretext;
    @JsonProperty("fallback")
    private String fallback;
    @JsonProperty("callback_id")
    private String callbackId;
    @JsonProperty("color")
    private String color;
    @JsonProperty("fields")
    private List<Field> fields = null;
    @JsonProperty("actions")
    private List<Action> actions = null;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("thumb_url")
    private String thumbUrl;
    @JsonProperty("footer")
    private String footer;
    @JsonProperty("footer_icon")
    private String footerIcon;
    @JsonProperty("mrkdwn_in")
    private List<String> mrkDwnIn;
    @JsonProperty("ts")
    private Integer ts;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -8755784212922920500L;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Attachment withTitle(String title) {
        this.title = title;
        return this;
    }

    @JsonProperty("title_link")
    public String getTitleLink() {
        return titleLink;
    }

    @JsonProperty("title_link")
    public void setTitleLink(String titleLink) {
        this.titleLink = titleLink;
    }

    public Attachment withTitleLink(String titleLink) {
        this.titleLink = titleLink;
        return this;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    public Attachment withText(String text) {
        this.text = text;
        return this;
    }

    @JsonProperty("pretext")
    public String getPretext() {
        return pretext;
    }

    @JsonProperty("pretext")
    public void setPretext(String pretext) {
        this.pretext = pretext;
    }

    public Attachment withPretext(String pretext) {
        this.pretext = pretext;
        return this;
    }

    @JsonProperty("fallback")
    public String getFallback() {
        return fallback;
    }

    @JsonProperty("fallback")
    public void setFallback(String fallback) {
        this.fallback = fallback;
    }

    public Attachment withFallback(String fallback) {
        this.fallback = fallback;
        return this;
    }

    @JsonProperty("callback_id")
    public String getCallbackId() {
        return callbackId;
    }

    @JsonProperty("callback_id")
    public void setCallbackId(String callbackId) {
        this.callbackId = callbackId;
    }

    public Attachment withCallbackId(String callbackId) {
        this.callbackId = callbackId;
        return this;
    }

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    public Attachment withColor(String color) {
        this.color = color;
        return this;
    }

    @JsonProperty("fields")
    public List<Field> getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public Attachment withFields(List<Field> fields) {
        this.fields = fields;
        return this;
    }

    @JsonProperty("actions")
    public List<Action> getActions() {
        return actions;
    }

    @JsonProperty("actions")
    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public Attachment withActions(List<Action> actions) {
        this.actions = actions;
        return this;
    }

    @JsonProperty("image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("image_url")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Attachment withImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @JsonProperty("thumb_url")
    public String getThumbUrl() {
        return thumbUrl;
    }

    @JsonProperty("thumb_url")
    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public Attachment withThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
        return this;
    }

    @JsonProperty("footer")
    public String getFooter() {
        return footer;
    }

    @JsonProperty("footer")
    public void setFooter(String footer) {
        this.footer = footer;
    }

    public Attachment withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    @JsonProperty("footer_icon")
    public String getFooterIcon() {
        return footerIcon;
    }

    @JsonProperty("footer_icon")
    public void setFooterIcon(String footerIcon) {
        this.footerIcon = footerIcon;
    }

    public Attachment withFooterIcon(String footerIcon) {
        this.footerIcon = footerIcon;
        return this;
    }

    @JsonProperty("mrkdwn_in")
    public List<String> getMrkDwnIn() {
        return mrkDwnIn;
    }

    @JsonProperty("mrkdwn_in")
    public void setMrkDwnIn(List<String> mrkDwnIn) {
        this.mrkDwnIn = mrkDwnIn;
    }

    public Attachment withMrkDwnIns(List<String> mrkDwnIn) {
        this.mrkDwnIn = mrkDwnIn;
        return this;
    }

    @JsonProperty("ts")
    public Integer getTs() {
        return ts;
    }

    @JsonProperty("ts")
    public void setTs(Integer ts) {
        this.ts = ts;
    }

    public Attachment withTs(Integer ts) {
        this.ts = ts;
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(text).append(ts).append(imageUrl).append(footerIcon).append(footer).append(pretext).append(fallback).append(title).append(titleLink).append(color).append(additionalProperties).append(callbackId).append(thumbUrl).append(actions).append(fields).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Attachment) == false) {
            return false;
        }
        Attachment rhs = ((Attachment) other);
        return new EqualsBuilder().append(text, rhs.text).append(ts, rhs.ts).append(imageUrl, rhs.imageUrl).append(footerIcon, rhs.footerIcon).append(footer, rhs.footer).append(pretext, rhs.pretext).append(fallback, rhs.fallback).append(title, rhs.title).append(titleLink, rhs.titleLink).append(color, rhs.color).append(additionalProperties, rhs.additionalProperties).append(callbackId, rhs.callbackId).append(thumbUrl, rhs.thumbUrl).append(actions, rhs.actions).append(fields, rhs.fields).isEquals();
    }

}
