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
    "title",
    "text",
    "ok_text",
    "dismiss_text"
})
public class Confirm implements Serializable
{

    @JsonProperty("title")
    private String title;
    @JsonProperty("text")
    private String text;
    @JsonProperty("ok_text")
    private String okText;
    @JsonProperty("dismiss_text")
    private String dismissText;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -119113469340703805L;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Confirm withTitle(String title) {
        this.title = title;
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

    public Confirm withText(String text) {
        this.text = text;
        return this;
    }

    @JsonProperty("ok_text")
    public String getOkText() {
        return okText;
    }

    @JsonProperty("ok_text")
    public void setOkText(String okText) {
        this.okText = okText;
    }

    public Confirm withOkText(String okText) {
        this.okText = okText;
        return this;
    }

    @JsonProperty("dismiss_text")
    public String getDismissText() {
        return dismissText;
    }

    @JsonProperty("dismiss_text")
    public void setDismissText(String dismissText) {
        this.dismissText = dismissText;
    }

    public Confirm withDismissText(String dismissText) {
        this.dismissText = dismissText;
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(dismissText).append(text).append(title).append(additionalProperties).append(okText).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Confirm) == false) {
            return false;
        }
        Confirm rhs = ((Confirm) other);
        return new EqualsBuilder().append(dismissText, rhs.dismissText).append(text, rhs.text).append(title, rhs.title).append(additionalProperties, rhs.additionalProperties).append(okText, rhs.okText).isEquals();
    }

}
