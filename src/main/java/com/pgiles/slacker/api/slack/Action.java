package com.pgiles.slacker.api.slack;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "text",
    "type",
    "value",
    "style",
    "confirm"
})
public class Action implements Serializable
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("text")
    private String text;
    @JsonProperty("type")
    private String type;
    @JsonProperty("value")
    private String value;
    @JsonProperty("style")
    private String style;
    @JsonProperty("confirm")
    private Confirm confirm;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = -2784199581075817667L;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Action withName(String name) {
        this.name = name;
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

    public Action withText(String text) {
        this.text = text;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Action withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    public Action withValue(String value) {
        this.value = value;
        return this;
    }

    @JsonProperty("style")
    public String getStyle() {
        return style;
    }

    @JsonProperty("style")
    public void setStyle(String style) {
        this.style = style;
    }

    public Action withStyle(String style) {
        this.style = style;
        return this;
    }

    @JsonProperty("confirm")
    public Confirm getConfirm() {
        return confirm;
    }

    @JsonProperty("confirm")
    public void setConfirm(Confirm confirm) {
        this.confirm = confirm;
    }

    public Action withConfirm(Confirm confirm) {
        this.confirm = confirm;
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(text).append(style).append(additionalProperties).append(name).append(value).append(type).append(confirm).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Action) == false) {
            return false;
        }
        Action rhs = ((Action) other);
        return new EqualsBuilder().append(text, rhs.text).append(style, rhs.style).append(additionalProperties, rhs.additionalProperties).append(name, rhs.name).append(value, rhs.value).append(type, rhs.type).append(confirm, rhs.confirm).isEquals();
    }

}
